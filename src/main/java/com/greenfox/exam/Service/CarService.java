package com.greenfox.exam.Service;

import com.greenfox.exam.Model.Car;
import com.greenfox.exam.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarService {

    public void showOnlyPolice() {
        setShowPolice(true);
        setShowDiplomat(false);
        setShowAll(false);
    }

    public void showOnlyDiplomat() {
        setShowPolice(false);
        setShowDiplomat(true);
        setShowAll(false);
    }

    public void showNormal() {
        setShowPolice(false);
        setShowDiplomat(false);
        setShowAll(true);
    }

    public boolean showPolice;
    public boolean showDiplomat;

    public boolean isShowPolice() {
        return showPolice;
    }

    public void setShowPolice(boolean showPolice) {
        this.showPolice = showPolice;
    }

    public boolean isShowDiplomat() {
        return showDiplomat;
    }

    public void setShowDiplomat(boolean showDiplomat) {
        this.showDiplomat = showDiplomat;
    }

    public boolean isShowAll() {
        return showAll;
    }

    public void setShowAll(boolean showAll) {
        this.showAll = showAll;
    }

    public boolean showAll;

    @Autowired
    CarRepository carRepository;

    public List<Car> listByPlateFragment(String fragment){
        return carRepository.findAllByPlateContaining(fragment);
    }

    public List<Car> findPolice() {
        return carRepository.findAllByPlateContaining("rb");
    }

    public List<Car> findDiplomat() {
        return carRepository.findAllByPlateContaining("dt");
    }


}
