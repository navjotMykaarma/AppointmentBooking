package io.github.navjotsrakhra.appointment_booking.repos;

import io.github.navjotsrakhra.appointment_booking.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarRepository extends JpaRepository<Car, Long> {
}
