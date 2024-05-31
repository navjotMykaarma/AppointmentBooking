package io.github.navjotsrakhra.appointment_booking.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UsernameAndPasswordDoesNotMatchException extends RuntimeException {

}
