package com.greenfox.exam.Repository;

import com.greenfox.exam.Model.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findAllByPlateContaining(String fragment);
    List<Car> findAllByBrand(String brand);
}
