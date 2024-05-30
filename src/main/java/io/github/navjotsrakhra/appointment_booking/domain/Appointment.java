package io.github.navjotsrakhra.appointment_booking.domain;

import io.github.navjotsrakhra.appointment_booking.model.Service;
import io.github.navjotsrakhra.appointment_booking.model.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


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
    private Status bookingStatus;

    @Column(columnDefinition = "longtext")
    private String notes;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Service serviceType; // TODO Convert to list

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

    public Status getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(final Status bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(final String notes) {
        this.notes = notes;
    }

    public Service getServiceType() {
        return serviceType;
    }

    public void setServiceType(final Service serviceType) {
        this.serviceType = serviceType;
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
