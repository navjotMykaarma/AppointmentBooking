package io.github.navjotsrakhra.appointment_booking.util.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PhoneNumber.PhoneNumberValidator.class})
public @interface PhoneNumber {

  String message() default "Invalid phone number";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
      if (value == null) {
        return false;
      }
      if (value.isBlank()) {
        return false;
      }
      if (value.length() != 10) {
        return false;
      }

      for (int i = 0; i < value.length(); i++) {
        char c = value.charAt(i);
        if (!Character.isDigit(c)) {
          return false;
        }
      }
      return true;
    }
  }
}
