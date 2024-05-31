package io.github.navjotsrakhra.appointment_booking.service;

import io.github.navjotsrakhra.appointment_booking.dao.AppointmentDao;
import io.github.navjotsrakhra.appointment_booking.domain.Appointment;
import io.github.navjotsrakhra.appointment_booking.mapper.AppointmentMapper;
import io.github.navjotsrakhra.appointment_booking.model.AppointmentDTO;
import io.github.navjotsrakhra.appointment_booking.model.request.AppointmentRequestDTO;
import io.github.navjotsrakhra.appointment_booking.model.response.AppointmentResponseDTO;
import io.github.navjotsrakhra.appointment_booking.repos.AppointmentRepository;
import io.github.navjotsrakhra.appointment_booking.util.exception.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class AppointmentService {

  private final AppointmentRepository appointmentRepository;
  private final AppointmentMapper appointmentMapper;
  private final AppointmentDao appointmentDao;

  public AppointmentService(final AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper, AppointmentDao appointmentDao) {
    this.appointmentRepository = appointmentRepository;
    this.appointmentMapper = appointmentMapper;
    this.appointmentDao = appointmentDao;
  }

  public Page<AppointmentResponseDTO> findAll(Pageable pageable) {
    Page<Appointment> appointments = appointmentDao.findAll(pageable);
    return appointments.map(appointmentMapper::appointmentToAppointmentResponseDTO);
  }

  public AppointmentResponseDTO get(final Long id) {
    return appointmentDao.findById(id)
      .map(appointmentMapper::appointmentToAppointmentResponseDTO)
      .orElseThrow(NotFoundException::new);
  }

  public Long create(final @Valid AppointmentRequestDTO appointmentDTO) {
    final Appointment appointment = appointmentMapper.appointmentRequestDTOToAppointment(appointmentDTO);
    return appointmentDao.save(appointment).getId();
  }

  public void update(final Long id, final @Valid AppointmentRequestDTO appointmentRequestDTO) {
    final Appointment appointment = appointmentDao.findById(id)
      .orElseThrow(NotFoundException::new);
    mapToEntity(appointmentRequestDTO, appointment);
    appointmentDao.save(appointment);
  }

  public void delete(final Long id) {
    appointmentDao.deleteById(id);
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

  private void mapToEntity(final @Valid AppointmentRequestDTO appointmentRequestDTO,
                           final Appointment appointment) {
    appointment.setCarId(appointmentRequestDTO.getCarId());
    appointment.setAppointmentDateTime(appointmentRequestDTO.getAppointmentDateTime());
    appointment.setNotes(appointmentRequestDTO.getNotes());
    appointment.setCarServiceType(appointmentRequestDTO.getCarServiceType());
  }

}
