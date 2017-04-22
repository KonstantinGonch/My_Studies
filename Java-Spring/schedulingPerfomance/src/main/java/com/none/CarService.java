package com.none;

import com.none.Car;

import java.util.List;

/**
 * Created by JohnCena on 12.04.2017.
 */
public interface CarService {
    List<Car> findAll();
    Car save(Car car);
    void updateCarAgeJob();
}
