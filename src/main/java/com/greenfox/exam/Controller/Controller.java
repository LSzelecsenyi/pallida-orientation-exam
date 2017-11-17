package com.greenfox.exam.Controller;

import com.greenfox.exam.Repository.CarRepository;
import com.greenfox.exam.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
@RequestMapping("/cars")
public class Controller {

    /*For whom will corerct this
    * Just to make you understand what this mess is:
    * First problem was, that I cannot import the database (spent 45 minutes on that)
    * Then was very nervous because of the wasted time, so I didn't read trough the
    * whole description (biggest mistake)
    * I started the project, tried to check how it looks in the browser, but I couldn't
    * connect to the server (spent another 35 minutes on that)
    * I decided to code something blindly, started it, but at a point I read the backend part
    * At this point I had 40 minutes left, lost all hope and motivation...*/

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarService carService;

    @GetMapping({"", "/"})
    public String getIndex() {
        return "index";
    }

    @GetMapping("/search")
    public String findCar(@RequestParam(value = "fragment", required = false) String fragment, Model model) {
        Error error = new Error();
        if (carService.isAlphanumeric(fragment)) {
            model.addAttribute(carService.listByPlateFragment(fragment));
        } else {
            error.setErrorText("Sorry, the submitted licence plate is not valid");
        }
        model.addAttribute("error", error);
        return "index";
    }

    @GetMapping("/search/{what}")
    public String findSpecial(@PathVariable(value = "what") String id) {
        carService.showOnlyPolice();
        return "redirect:index";
    }

    @GetMapping("/searchdiplomat")
    public String findDiplomat() {
        carService.showOnlyDiplomat();
        return "redirect:index";
    }

    @GetMapping("/{brand}/searchbybrand")
    public String findByBrand(@PathVariable(value = "brand") String brand) {
        carService.showByBrand();
        return "redirect:index";
    }



}
