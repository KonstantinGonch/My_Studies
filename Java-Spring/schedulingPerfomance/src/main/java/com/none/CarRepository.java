package com.none;

import com.none.Car;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by JohnCena on 12.04.2017.
 */
public interface CarRepository extends CrudRepository<Car, Long> {
}
