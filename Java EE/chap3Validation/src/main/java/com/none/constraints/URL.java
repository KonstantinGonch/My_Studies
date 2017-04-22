package com.none.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.TYPE, ElementType.FIELD})
@Documented
@Constraint(validatedBy = URLValidator.class)
public @interface URL {
    String message() default "Malformed URL";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String host() default "";
    String protocol() default "";
    int port() default -1;
}
