package com.none.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by JohnCena on 16.04.2017.
 */
public class NotNullValidator implements ConstraintValidator<NotNull, Object> {
    public void initialize(NotNull notNull) {

    }

    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return o != null;
    }
}
