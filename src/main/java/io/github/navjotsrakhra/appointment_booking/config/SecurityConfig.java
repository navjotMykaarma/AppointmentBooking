package io.github.navjotsrakhra.appointment_booking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
      .csrf(
        AbstractHttpConfigurer::disable
      )
      .authorizeHttpRequests(
        authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
          .requestMatchers("/api/**").authenticated()
          .anyRequest().permitAll()
      )
      .formLogin(
        httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer
          .loginPage("/login")
          .loginProcessingUrl("/login")
      )
      .logout(
        httpSecurityLogoutConfigurer -> httpSecurityLogoutConfigurer
          .deleteCookies("JSESSIONID")
      )
      .build();
  }
}
