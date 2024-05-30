package io.github.navjotsrakhra.appointment_booking.model;

import jakarta.validation.constraints.NotNull;
import java.time.OffsetDateTime;


public class AppointmentDTO {

    private Long id;

    @NotNull
    @AppointmentUserIdUnique
    private Long userId;

    private Long carId;

    @NotNull
    @AppointmentAppointmentDateTimeUnique
    private OffsetDateTime appointmentDateTime;

    @NotNull
    private Status bookingStatus;

    private String notes;

    @NotNull
    private Service serviceType;

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

}
