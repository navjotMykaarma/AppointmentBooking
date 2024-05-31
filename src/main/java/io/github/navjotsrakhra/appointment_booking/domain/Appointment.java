package io.github.navjotsrakhra.appointment_booking.domain;

import io.github.navjotsrakhra.appointment_booking.model.CarService;
import io.github.navjotsrakhra.appointment_booking.model.CarServiceStatus;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.OffsetDateTime;


@Entity
@Table(name = "Appointments")
@EntityListeners(AuditingEntityListener.class)
public class Appointment {

  @Id
  @Column(nullable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private Long userId;

  @Column
  private Long carId;

  @Column(nullable = false, unique = true)
  private OffsetDateTime appointmentDateTime;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private CarServiceStatus bookingCarServiceStatus;

  @Column(columnDefinition = "longtext")
  private String notes;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private CarService carServiceType; // TODO Convert to list

  @CreatedDate
  @Column(nullable = false, updatable = false)
  private OffsetDateTime dateCreated;

  @LastModifiedDate
  @Column(nullable = false)
  private OffsetDateTime lastUpdated;

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

  public CarService getCarServiceType() {
    return carServiceType;
  }

  public void setCarServiceType(final CarService carServiceType) {
    this.carServiceType = carServiceType;
  }

  public OffsetDateTime getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(final OffsetDateTime dateCreated) {
    this.dateCreated = dateCreated;
  }

  public OffsetDateTime getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(final OffsetDateTime lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

}
