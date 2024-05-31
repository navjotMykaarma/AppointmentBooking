package io.github.navjotsrakhra.appointment_booking.service;

import io.github.navjotsrakhra.appointment_booking.dao.CarDao;
import io.github.navjotsrakhra.appointment_booking.domain.Car;
import io.github.navjotsrakhra.appointment_booking.mapper.CarMapper;
import io.github.navjotsrakhra.appointment_booking.model.request.CarRequestDTO;
import io.github.navjotsrakhra.appointment_booking.model.response.CarResponseDTO;
import io.github.navjotsrakhra.appointment_booking.util.exception.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarService {

  private final CarDao carDao;
  private final CarMapper carMapper;

  public CarService(CarDao carDao, CarMapper carMapper) {
    this.carDao = carDao;
    this.carMapper = carMapper;
  }

  public List<CarResponseDTO> findAll() {
    final List<Car> cars = carDao.findAll();
    return cars.stream()
      .map(carMapper::carToCarResponseDTO)
      .toList();
  }

  public CarResponseDTO get(final Long id) {
    return carDao.findById(id)
      .map(carMapper::carToCarResponseDTO)
      .orElseThrow(NotFoundException::new);
  }

  public Long create(final @Valid CarRequestDTO carRequestDTO) {
    final Car car = carMapper.carRequestDTOToCar(carRequestDTO);
    return carDao.save(car).getId();
  }

  public void update(final Long id, final CarRequestDTO carRequestDTO) {
    final Car car = carDao.findById(id)
      .orElseThrow(NotFoundException::new);
    mapToEntity(carRequestDTO, car);
    carDao.save(car);
  }

  public void delete(final Long id) {
    carDao.deleteById(id);
  }

  private void mapToEntity(final CarRequestDTO carRequestDTO, final Car car) {
    car.setVin(carRequestDTO.getVin());
    car.setMake(carRequestDTO.getMake());
    car.setModel(carRequestDTO.getModel());
    car.setLicensePlateNumber(carRequestDTO.getLicensePlateNumber());
    car.setUserID(carRequestDTO.getUserId());
  }

}
