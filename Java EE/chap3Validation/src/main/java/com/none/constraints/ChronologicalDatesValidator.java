package com.none.constraints;

import com.none.models.Order;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

/**
 * Created by JohnCena on 16.04.2017.
 */
public class ChronologicalDatesValidator implements ConstraintValidator<ChronologicalDates, Order> {
    public void initialize(ChronologicalDates chronologicalDates) {

    }

    public boolean isValid(Order order, ConstraintValidatorContext constraintValidatorContext) {
        return order.getCreationDate().getTime() < order.getPaymentDate().getTime() &&
                order.getPaymentDate().getTime() < order.getDeliveryDate().getTime();
    }
}
