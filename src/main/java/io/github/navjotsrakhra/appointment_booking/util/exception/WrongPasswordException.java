package io.github.navjotsrakhra.appointment_booking.util.exception;

public class WrongPasswordException extends RuntimeException {
  public WrongPasswordException(String message) {
    super(message);
  }
}
