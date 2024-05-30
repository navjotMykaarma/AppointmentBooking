package io.github.navjotsrakhra.appointment_booking.model;


import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum Role {

  ADMIN,
  USER,
  BCD,
  CASHIER,
  TECHNICIAN,
  DEALERSHIP_MANAGER;

  public SimpleGrantedAuthority getAuthority() {
    return new SimpleGrantedAuthority("ROLE_" + name());
  }

  public String getRoleName() {
    return "ROLE_" + name();
  }
}
