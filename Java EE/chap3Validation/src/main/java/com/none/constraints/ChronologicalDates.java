package com.none.constraints;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Constraint(validatedBy = ChronologicalDatesValidator.class)
public @interface ChronologicalDates {
}
