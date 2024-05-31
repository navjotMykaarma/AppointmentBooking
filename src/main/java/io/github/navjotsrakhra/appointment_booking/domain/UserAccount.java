package io.github.navjotsrakhra.appointment_booking.domain;

import io.github.navjotsrakhra.appointment_booking.model.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "UserAccounts")
@EntityListeners(AuditingEntityListener.class)
public class UserAccount implements UserDetails {

  @Id
  @Column(nullable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private Boolean accountExpired;

  @Column(nullable = false)
  private Boolean accountLocked;

  @Column(nullable = false)
  private Boolean credentialsExpired;

  @Column(nullable = false, columnDefinition = "longtext")
  @JdbcTypeCode(SqlTypes.JSON)
  private List<Role> roles;

  @Column(nullable = false)
  @Email
  private String email;

  @Column(nullable = false)
  private Integer phoneNumber;

  @Column(nullable = false, columnDefinition = "longtext")
  private String address;

  @CreatedDate
  @Column(nullable = false, updatable = false)
  private OffsetDateTime dateCreated;

  @LastModifiedDate
  @Column(nullable = false)
  private OffsetDateTime lastUpdated;

  @Override
  public boolean isAccountNonExpired() {
    return !accountExpired;
  }

  @Override
  public boolean isAccountNonLocked() {
    return !accountLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return !credentialsExpired;
  }

  @Override
  public boolean isEnabled() {
    return UserDetails.super.isEnabled();
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return roles.stream().map(Role::getAuthority).toList();
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public Boolean getAccountExpired() {
    return accountExpired;
  }

  public void setAccountExpired(final Boolean accountExpired) {
    this.accountExpired = accountExpired;
  }

  public Boolean getAccountLocked() {
    return accountLocked;
  }

  public void setAccountLocked(final Boolean accountLocked) {
    this.accountLocked = accountLocked;
  }

  public Boolean getCredentialsExpired() {
    return credentialsExpired;
  }

  public void setCredentialsExpired(final Boolean credentialsExpired) {
    this.credentialsExpired = credentialsExpired;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(final List<Role> roles) {
    this.roles = roles;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public Integer getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(final Integer phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(final String address) {
    this.address = address;
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
