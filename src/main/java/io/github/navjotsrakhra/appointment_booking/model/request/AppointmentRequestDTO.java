package io.github.navjotsrakhra.appointment_booking.model.request;

import io.github.navjotsrakhra.appointment_booking.model.CarService;
import io.github.navjotsrakhra.appointment_booking.util.validation.annotation.AppointmentAppointmentDateTimeUnique;

import java.time.OffsetDateTime;

public class AppointmentRequestDTO {
  private Long carId;
  @AppointmentAppointmentDateTimeUnique
  private OffsetDateTime appointmentDateTime;
  private String notes;
  private CarService carServiceType;

  public void setCarId(Long carId) {
    this.carId = carId;
  }

  public void setAppointmentDateTime(OffsetDateTime appointmentDateTime) {
    this.appointmentDateTime = appointmentDateTime;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public void setCarServiceType(CarService carServiceType) {
    this.carServiceType = carServiceType;
  }
}
