package com.none;

import com.google.common.collect.Lists;
import com.none.Car;
import com.none.CarRepository;
import com.none.CarService;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("carService")
@Repository
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    public List<Car> findAll() {
        return Lists.newArrayList(carRepository.findAll());
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public void updateCarAgeJob() {
        List<Car> cars = findAll();
        DateTime currentDate = DateTime.now();
        for(Car car : cars)
        {
            int age = Years.yearsBetween(car.getManufactureDate(), currentDate).getYears();
            car.setAge(age);
            save(car);
        }
    }
}
