package io.github.navjotsrakhra.appointment_booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;


@SpringBootApplication
@EnableMethodSecurity
public class AppointmentBookingApplication {

    public static void main(final String[] args) {
        SpringApplication.run(AppointmentBookingApplication.class, args);
    }

}
