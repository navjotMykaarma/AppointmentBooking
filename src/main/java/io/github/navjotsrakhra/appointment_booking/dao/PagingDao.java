package io.github.navjotsrakhra.appointment_booking.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PagingDao<T> {
  Page<T> findAll(Pageable pageable);
}
