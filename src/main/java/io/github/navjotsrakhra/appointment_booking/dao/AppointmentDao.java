package io.github.navjotsrakhra.appointment_booking.dao;

import io.github.navjotsrakhra.appointment_booking.domain.Appointment;
import io.github.navjotsrakhra.appointment_booking.repos.AppointmentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class AppointmentDao implements Dao<Appointment>, PagingDao<Appointment> {

  private final AppointmentRepository repository;

  public AppointmentDao(AppointmentRepository repository) {
    this.repository = repository;
  }

  @Override
  public Appointment save(Appointment appointment) {
    return repository.save(appointment);
  }

  @Override
  public Appointment update(Appointment appointment) {
    return save(appointment);
  }

  @Override
  public Appointment delete(Appointment appointment) {
    repository.delete(appointment);
    return appointment;
  }

  @Override
  public Optional<Appointment> findById(Long id) {
    return repository.findById(id);
  }

  @Override
  public List<Appointment> findAll() {
    return repository.findAll();
  }

  @Override
  public Page<Appointment> findAll(Pageable pageable) {
    return repository.findAll(pageable);
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
