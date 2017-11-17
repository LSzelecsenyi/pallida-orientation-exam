package com.greenfox.exam.Controller;

import com.greenfox.exam.Repository.CarRepository;
import com.greenfox.exam.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
@RequestMapping("/cars")
public class Controller {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarService carService;

    @GetMapping({"", "/"})
    public String getIndex() {
        return "index";
    }

    @GetMapping("/search")
    public String findCar(@RequestParam String fragment, Model model) {
        carService.showNormal();
        model.addAttribute("list", carService.listByPlateFragment(fragment));
        model.addAttribute("policeCarList", carService.listByPlateFragment("RB"));
        model.addAttribute("diplomatCarList", carService.listByPlateFragment("DT"));
        return "index";
    }

    @GetMapping("/searchpolice")
    public String findPolice() {
        carService.showOnlyPolice();
        return "index";
    }

    @GetMapping("/searchdiplomat")
    public String findDiplomat() {
        carService.showOnlyDiplomat();
        return "index";
    }

}
