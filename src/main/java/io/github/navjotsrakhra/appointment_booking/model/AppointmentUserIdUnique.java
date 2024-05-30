package io.github.navjotsrakhra.appointment_booking.model;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import io.github.navjotsrakhra.appointment_booking.service.AppointmentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;
import org.springframework.web.servlet.HandlerMapping;


/**
 * Validate that the userId value isn't taken yet.
 */
@Target({ FIELD, METHOD, ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = AppointmentUserIdUnique.AppointmentUserIdUniqueValidator.class
)
public @interface AppointmentUserIdUnique {

    String message() default "{Exists.appointment.userId}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class AppointmentUserIdUniqueValidator implements ConstraintValidator<AppointmentUserIdUnique, Long> {

        private final AppointmentService appointmentService;
        private final HttpServletRequest request;

        public AppointmentUserIdUniqueValidator(final AppointmentService appointmentService,
                final HttpServletRequest request) {
            this.appointmentService = appointmentService;
            this.request = request;
        }

        @Override
        public boolean isValid(final Long value, final ConstraintValidatorContext cvContext) {
            if (value == null) {
                // no value present
                return true;
            }
            @SuppressWarnings("unchecked") final Map<String, String> pathVariables =
                    ((Map<String, String>)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE));
            final String currentId = pathVariables.get("id");
            if (currentId != null && value.equals(appointmentService.get(Long.parseLong(currentId)).getUserId())) {
                // value hasn't changed
                return true;
            }
            return !appointmentService.userIdExists(value);
        }

    }

}
