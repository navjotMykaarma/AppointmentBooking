package io.github.navjotsrakhra.appointment_booking.service;

import io.github.navjotsrakhra.appointment_booking.domain.Appointment;
import io.github.navjotsrakhra.appointment_booking.mapper.AppointmentMapper;
import io.github.navjotsrakhra.appointment_booking.model.AppointmentDTO;
import io.github.navjotsrakhra.appointment_booking.repos.AppointmentRepository;
import io.github.navjotsrakhra.appointment_booking.util.exception.NotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;


@Service
public class AppointmentService {

  private final AppointmentRepository appointmentRepository;
  private final AppointmentMapper appointmentMapper;

  public AppointmentService(final AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper) {
    this.appointmentRepository = appointmentRepository;
    this.appointmentMapper = appointmentMapper;
  }

  public List<AppointmentDTO> findAll() {
    final List<Appointment> appointments = appointmentRepository.findAll(Sort.by("id"));
    return appointments.stream()
      .map(appointment -> mapToDTO(appointment, new AppointmentDTO()))
      .toList();
  }

  public AppointmentDTO get(final Long id) {
    return appointmentRepository.findById(id)
      .map(appointment -> mapToDTO(appointment, new AppointmentDTO()))
      .orElseThrow(NotFoundException::new);
  }

  public Long create(final AppointmentDTO appointmentDTO) {
    final Appointment appointment = new Appointment();
    mapToEntity(appointmentDTO, appointment);
    return appointmentRepository.save(appointment).getId();
  }

  public void update(final Long id, final AppointmentDTO appointmentDTO) {
    final Appointment appointment = appointmentRepository.findById(id)
      .orElseThrow(NotFoundException::new);
    mapToEntity(appointmentDTO, appointment);
    appointmentRepository.save(appointment);
  }

  public void delete(final Long id) {
    appointmentRepository.deleteById(id);
  }

  private AppointmentDTO mapToDTO(final Appointment appointment,
                                  final AppointmentDTO appointmentDTO) {
    appointmentDTO.setId(appointment.getId());
    appointmentDTO.setUserId(appointment.getUserId());
    appointmentDTO.setCarId(appointment.getCarId());
    appointmentDTO.setAppointmentDateTime(appointment.getAppointmentDateTime());
    appointmentDTO.setBookingStatus(appointment.getBookingStatus());
    appointmentDTO.setNotes(appointment.getNotes());
    appointmentDTO.setServiceType(appointment.getCarServiceType());
    return appointmentDTO;
  }

  private Appointment mapToEntity(final AppointmentDTO appointmentDTO,
                                  final Appointment appointment) {
    appointment.setUserId(appointmentDTO.getUserId());
    appointment.setCarId(appointmentDTO.getCarId());
    appointment.setAppointmentDateTime(appointmentDTO.getAppointmentDateTime());
    appointment.setBookingStatus(appointmentDTO.getBookingStatus());
    appointment.setNotes(appointmentDTO.getNotes());
    appointment.setCarServiceType(appointmentDTO.getServiceType());
    return appointment;
  }

  public boolean userIdExists(final Long userId) {
    return appointmentRepository.existsByUserId(userId);
  }

  public boolean appointmentDateTimeExists(final OffsetDateTime appointmentDateTime) {
    return appointmentRepository.existsByAppointmentDateTime(appointmentDateTime);
  }

}
