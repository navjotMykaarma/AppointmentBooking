package io.github.navjotsrakhra.appointment_booking.model.response;

import io.github.navjotsrakhra.appointment_booking.model.CarService;

import java.time.OffsetDateTime;

public class AppointmentResponseDTO {
  private Long id;
  private Long carId;
  private OffsetDateTime appointmentDateTime;
  private String notes;
  private CarService carServiceType;

  public void setId(Long id) {
    this.id = id;
  }

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
