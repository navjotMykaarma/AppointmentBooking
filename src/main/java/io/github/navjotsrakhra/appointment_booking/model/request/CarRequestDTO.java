package io.github.navjotsrakhra.appointment_booking.model.request;

public class CarRequestDTO {
  private String vin;
  private String make;
  private String model;
  private String licensePlateNumber;
  private Long userId;

  public CarRequestDTO(String vin, String make, String model, String licensePlateNumber, Long userId) {
    this.vin = vin;
    this.make = make;
    this.model = model;
    this.licensePlateNumber = licensePlateNumber;
    this.userId = userId;
  }

  public CarRequestDTO() {
  }

  public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getLicensePlateNumber() {
    return licensePlateNumber;
  }

  public void setLicensePlateNumber(String licensePlateNumber) {
    this.licensePlateNumber = licensePlateNumber;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}
