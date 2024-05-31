package io.github.navjotsrakhra.appointment_booking.model.response;

import io.github.navjotsrakhra.appointment_booking.model.CarService;
import io.github.navjotsrakhra.appointment_booking.model.CarServiceStatus;

import java.time.OffsetDateTime;

public class AppointmentResponseDTO {
  private Long id;
  private Long carId;
  private OffsetDateTime appointmentDateTime;
  private CarServiceStatus bookingCarServiceStatus;
  private String notes;
  private CarService carServiceType;
  public AppointmentResponseDTO() {
  }
  public AppointmentResponseDTO(Long id, Long carId, OffsetDateTime appointmentDateTime, String notes, CarService carServiceType) {
    this.id = id;
    this.carId = carId;
    this.appointmentDateTime = appointmentDateTime;
    this.notes = notes;
    this.carServiceType = carServiceType;
  }

  public CarServiceStatus getBookingCarServiceStatus() {
    return bookingCarServiceStatus;
  }

  public void setBookingCarServiceStatus(CarServiceStatus bookingCarServiceStatus) {
    this.bookingCarServiceStatus = bookingCarServiceStatus;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
