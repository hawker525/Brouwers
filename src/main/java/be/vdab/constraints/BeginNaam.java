package be.vdab.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Maarten Westelinck on 27/02/2017 for Brouwers.
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BeginNaamValidator.class)
public @interface BeginNaam {
    String message() default "{be.vdab.constraints.BeginNaam}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
