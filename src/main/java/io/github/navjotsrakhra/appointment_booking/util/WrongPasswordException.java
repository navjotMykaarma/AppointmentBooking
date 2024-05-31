package io.github.navjotsrakhra.appointment_booking.util;

public class WrongPasswordException extends RuntimeException {
  public WrongPasswordException(String message) {
    super(message);
  }
}
