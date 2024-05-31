package io.github.navjotsrakhra.appointment_booking.config;

import io.github.navjotsrakhra.appointment_booking.dao.UserAccountDao;
import io.github.navjotsrakhra.appointment_booking.repos.UserAccountRepository;
import io.github.navjotsrakhra.appointment_booking.util.UsernameAndPasswordDoesNotMatchException;
import io.github.navjotsrakhra.appointment_booking.util.UsernameNotFound;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.function.Supplier;

@Configuration
public class UserAccountConfig {
  @Bean
  public UserDetailsService userDetailsService(UserAccountDao userAccountDao) {
    return
      username -> userAccountDao
        .findByUsername(username)
        .orElseThrow(() -> new UsernameNotFound("Username not found."));
  }
}
