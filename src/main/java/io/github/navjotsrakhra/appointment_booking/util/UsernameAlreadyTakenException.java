package io.github.navjotsrakhra.appointment_booking.util;

public class UsernameAlreadyTakenException extends RuntimeException {
  public UsernameAlreadyTakenException(String s) {
    super(s);
  }
}
