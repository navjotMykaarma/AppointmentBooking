package io.github.navjotsrakhra.appointment_booking.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
  T save(T t);

  T update(T t);

  T delete(T t);

  Optional<T> findById(Long id);

  List<T> findAll();
}
