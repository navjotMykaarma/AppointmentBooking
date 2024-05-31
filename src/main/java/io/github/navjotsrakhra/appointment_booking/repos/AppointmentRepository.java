package io.github.navjotsrakhra.appointment_booking.repos;

import io.github.navjotsrakhra.appointment_booking.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>, PagingAndSortingRepository<Appointment, Long> {

  boolean existsByUserId(Long userId);

  boolean existsByAppointmentDateTime(OffsetDateTime appointmentDateTime);

}
