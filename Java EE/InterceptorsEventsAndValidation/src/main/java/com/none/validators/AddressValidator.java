package com.none.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class AddressValidator implements ConstraintValidator<IsRussian, String> {

    private String address;

    public void initialize(IsRussian isRussian) {
        this.address = isRussian.address();
    }

    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate("Not russian, current value - "+s).addConstraintViolation();
        return s.startsWith("RF");
    }
}
