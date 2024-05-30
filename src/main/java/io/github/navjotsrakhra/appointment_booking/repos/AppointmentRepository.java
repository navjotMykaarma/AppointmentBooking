package io.github.navjotsrakhra.appointment_booking.repos;

import io.github.navjotsrakhra.appointment_booking.domain.Appointment;
import java.time.OffsetDateTime;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    boolean existsByUserId(Long userId);

    boolean existsByAppointmentDateTime(OffsetDateTime appointmentDateTime);

}
