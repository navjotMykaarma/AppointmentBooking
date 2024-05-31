package io.github.navjotsrakhra.appointment_booking.mapper;

import io.github.navjotsrakhra.appointment_booking.domain.Appointment;
import io.github.navjotsrakhra.appointment_booking.model.request.AppointmentRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
  Appointment appointmentRequestDTOToAppointment(AppointmentRequestDTO appointmentRequestDTO);

  AppointmentRequestDTO appointmentToAppointmentResponseDTO(Appointment appointment);
}
