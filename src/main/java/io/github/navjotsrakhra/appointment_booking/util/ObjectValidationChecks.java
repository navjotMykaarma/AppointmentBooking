package io.github.navjotsrakhra.appointment_booking.util;

import java.util.Objects;

public class ObjectValidationChecks { // TODO delete if not used
  public static void requireNotNull(Object... obj) {
    for (Object o : obj) {
      Objects.requireNonNull(o);
    }
  }
}
