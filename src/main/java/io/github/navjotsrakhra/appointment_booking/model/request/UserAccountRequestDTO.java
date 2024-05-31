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

  public @NotNull @NotBlank String getUsername() {
    return username;
  }

  public @NotNull @NotBlank String getPassword() {
    return password;
  }

  public @NotNull @NotBlank @Email String getEmail() {
    return email;
  }

  public @NotNull @NotBlank String getPhoneNumber() {
    return phoneNumber;
  }

  public @NotNull @NotBlank String getAddress() {
    return address;
  }
}
