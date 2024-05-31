package io.github.navjotsrakhra.appointment_booking.model;

import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;


public class AppointmentDTO {

  private Long id;

  @NotNull
  private Long userId;

  private Long carId;

  @NotNull
  private OffsetDateTime appointmentDateTime;

  @NotNull
  private CarServiceStatus bookingCarServiceStatus;

  private String notes;

  @NotNull
  private CarService carServiceType;

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(final Long userId) {
    this.userId = userId;
  }

  public Long getCarId() {
    return carId;
  }

  public void setCarId(final Long carId) {
    this.carId = carId;
  }

  public OffsetDateTime getAppointmentDateTime() {
    return appointmentDateTime;
  }

  public void setAppointmentDateTime(final OffsetDateTime appointmentDateTime) {
    this.appointmentDateTime = appointmentDateTime;
  }

  public CarServiceStatus getBookingStatus() {
    return bookingCarServiceStatus;
  }

  public void setBookingStatus(final CarServiceStatus bookingCarServiceStatus) {
    this.bookingCarServiceStatus = bookingCarServiceStatus;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(final String notes) {
    this.notes = notes;
  }

  public CarService getServiceType() {
    return carServiceType;
  }

  public void setServiceType(final CarService carServiceType) {
    this.carServiceType = carServiceType;
  }

}
