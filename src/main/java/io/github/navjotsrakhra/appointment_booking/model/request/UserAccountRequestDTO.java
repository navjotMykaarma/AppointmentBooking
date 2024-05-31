package io.github.navjotsrakhra.appointment_booking.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserAccountRequestDTO {
  @NotNull
  @NotBlank
  private String username;
  @NotNull
  @NotBlank
  private String password;
  @NotNull
  @NotBlank
  @Email
  private String email;
  @NotNull
  @NotBlank
  private String phoneNumber;
  @NotNull
  @NotBlank
  private String address;

  public UserAccountRequestDTO() {
  }

  public UserAccountRequestDTO(String username, String password, String email, String phoneNumber, String address) {
    this.username = username;
    this.password = password;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.address = address;
  }

  public @NotNull @NotBlank String getUsername() {
    return username;
  }

  public void setUsername(@NotNull @NotBlank String username) {
    this.username = username;
  }

  public @NotNull @NotBlank String getPassword() {
    return password;
  }

  public void setPassword(@NotNull @NotBlank String password) {
    this.password = password;
  }

  public @NotNull @NotBlank @Email String getEmail() {
    return email;
  }

  public void setEmail(@NotNull @NotBlank @Email String email) {
    this.email = email;
  }

  public @NotNull @NotBlank String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(@NotNull @NotBlank String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public @NotNull @NotBlank String getAddress() {
    return address;
  }

  public void setAddress(@NotNull @NotBlank String address) {
    this.address = address;
  }
}
