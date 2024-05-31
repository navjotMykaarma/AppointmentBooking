package io.github.navjotsrakhra.appointment_booking.mapper;

import io.github.navjotsrakhra.appointment_booking.domain.Appointment;
import io.github.navjotsrakhra.appointment_booking.model.request.AppointmentRequestDTO;
import io.github.navjotsrakhra.appointment_booking.model.response.AppointmentResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
  Appointment appointmentRequestDTOToAppointment(AppointmentRequestDTO appointmentRequestDTO);

  AppointmentResponseDTO appointmentToAppointmentResponseDTO(Appointment appointment);

  AppointmentRequestDTO appointmentToAppointmentRequestDTO(Appointment appointment);
}
