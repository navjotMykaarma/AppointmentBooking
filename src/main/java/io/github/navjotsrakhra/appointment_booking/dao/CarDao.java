package io.github.navjotsrakhra.appointment_booking.dao;

import io.github.navjotsrakhra.appointment_booking.domain.Car;
import io.github.navjotsrakhra.appointment_booking.repos.CarRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarDao implements Dao<Car> {
  private final CarRepository repository;

  public CarDao(CarRepository repository) {
    this.repository = repository;
  }

  @Override
  public Car save(Car car) {
    return repository.save(car);
  }

  @Override
  public Car update(Car car) {
    return repository.save(car);
  }

  @Override
  public Car delete(Car car) {
    repository.delete(car);
    return car;
  }

  @Override
  public Optional<Car> findById(Long id) {
    return repository.findById(id);
  }

  @Override
  public List<Car> findAll() {
    return repository.findAll();
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
