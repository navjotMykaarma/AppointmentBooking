package io.github.navjotsrakhra.appointment_booking.model;


import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum Role {

  ADMIN,
  USER,
  BCD,
  DEALERSHIP_MANAGER;

  public SimpleGrantedAuthority getAuthority() {
    return new SimpleGrantedAuthority("ROLE_" + name());
  }
}
