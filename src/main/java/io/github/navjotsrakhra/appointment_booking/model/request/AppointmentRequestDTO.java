package io.github.navjotsrakhra.appointment_booking.model.request;

import io.github.navjotsrakhra.appointment_booking.model.CarService;

import java.time.OffsetDateTime;

public class AppointmentRequestDTO {
  private Long carId;
  private OffsetDateTime appointmentDateTime;
  private String notes;
  private CarService carServiceType;

  public AppointmentRequestDTO(Long carId, OffsetDateTime appointmentDateTime, String notes, CarService carServiceType) {
    this.carId = carId;
    this.appointmentDateTime = appointmentDateTime;
    this.notes = notes;
    this.carServiceType = carServiceType;
  }

  public AppointmentRequestDTO() {
  }

  public Long getCarId() {
    return carId;
  }

  public void setCarId(Long carId) {
    this.carId = carId;
  }

  public OffsetDateTime getAppointmentDateTime() {
    return appointmentDateTime;
  }

  public void setAppointmentDateTime(OffsetDateTime appointmentDateTime) {
    this.appointmentDateTime = appointmentDateTime;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public CarService getCarServiceType() {
    return carServiceType;
  }

  public void setCarServiceType(CarService carServiceType) {
    this.carServiceType = carServiceType;
  }
}
