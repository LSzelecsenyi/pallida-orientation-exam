package com.greenfox.exam.Service;

import com.greenfox.exam.Model.Car;
import com.greenfox.exam.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarService {

    @Autowired
    CarRepository carRepository;

    public boolean showPolice;
    public boolean showDiplomat;
    public boolean showAll;
    public boolean showByBrand;

    public boolean isAlphanumeric(String str) {
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (c < 0x30 || (c >= 0x3a && c <= 0x40) || (c > 0x5a && c <= 0x60) || c > 0x7a)
                return false;
        }
        return true;
    }

    public void showOnlyPolice() {
        setShowPolice(true);
        setShowDiplomat(false);
        setShowAll(false);
        setShowByBrand(false);
    }

    public void showOnlyDiplomat() {
        setShowPolice(false);
        setShowDiplomat(true);
        setShowAll(false);
        setShowByBrand(false);
    }

    public void showNormal() {
        setShowPolice(false);
        setShowDiplomat(false);
        setShowAll(true);
        setShowByBrand(false);
    }

    public void showByBrand() {
        setShowPolice(false);
        setShowDiplomat(false);
        setShowAll(false);
        setShowByBrand(true);
    }

    public List<Car> listByBrand(String brand){
        return carRepository.findAllByBrand(brand);
    }

    public List<Car> listByPlateFragment(String fragment){
        return carRepository.findAllByPlateContaining(fragment);
    }

    public List<Car> findPolice() {
        return carRepository.findAllByPlateContaining("rb");
    }

    public List<Car> findDiplomat() {
        return carRepository.findAllByPlateContaining("dt");
    }


    public void setShowPolice(boolean showPolice) {
        this.showPolice = showPolice;
    }

    public boolean isShowDiplomat() {
        return showDiplomat;
    }

    public boolean isShowPolice() {
        return showPolice;
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

    public boolean isShowByBrand() {
        return showByBrand;
    }

    public void setShowByBrand(boolean showByBrand) {
        this.showByBrand = showByBrand;
    }
}
