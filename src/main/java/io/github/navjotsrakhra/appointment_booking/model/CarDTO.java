package io.github.navjotsrakhra.appointment_booking.model;

import jakarta.validation.constraints.Size;


public class CarDTO {

    private Long id;

    @Size(max = 255)
    private String vin;

    @Size(max = 255)
    private String make;

    @Size(max = 255)
    private String model;

    @Size(max = 255)
    private String licensePlateNumber;

    private Long userID;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(final String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(final String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(final String model) {
        this.model = model;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(final String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(final Long userID) {
        this.userID = userID;
    }

}
