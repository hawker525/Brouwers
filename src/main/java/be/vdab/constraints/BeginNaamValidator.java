package be.vdab.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Maarten Westelinck on 27/02/2017 for Brouwers.
 */
public class BeginNaamValidator implements ConstraintValidator<BeginNaam, String> {
   public void initialize(BeginNaam constraint) {
   }

   public boolean isValid(String naam, ConstraintValidatorContext context) {
        return naam == null || naam.matches("^[a-zA-z]+$");
   }
}
