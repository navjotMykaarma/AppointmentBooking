package io.github.navjotsrakhra.appointment_booking.service;

import io.github.navjotsrakhra.appointment_booking.domain.Car;
import io.github.navjotsrakhra.appointment_booking.model.CarDTO;
import io.github.navjotsrakhra.appointment_booking.repos.CarRepository;
import io.github.navjotsrakhra.appointment_booking.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(final CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarDTO> findAll() {
        final List<Car> cars = carRepository.findAll(Sort.by("id"));
        return cars.stream()
                .map(car -> mapToDTO(car, new CarDTO()))
                .toList();
    }

    public CarDTO get(final Long id) {
        return carRepository.findById(id)
                .map(car -> mapToDTO(car, new CarDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final CarDTO carDTO) {
        final Car car = new Car();
        mapToEntity(carDTO, car);
        return carRepository.save(car).getId();
    }

    public void update(final Long id, final CarDTO carDTO) {
        final Car car = carRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(carDTO, car);
        carRepository.save(car);
    }

    public void delete(final Long id) {
        carRepository.deleteById(id);
    }

    private CarDTO mapToDTO(final Car car, final CarDTO carDTO) {
        carDTO.setId(car.getId());
        carDTO.setVin(car.getVin());
        carDTO.setMake(car.getMake());
        carDTO.setModel(car.getModel());
        carDTO.setLicensePlateNumber(car.getLicensePlateNumber());
        carDTO.setUserID(car.getUserID());
        return carDTO;
    }

    private Car mapToEntity(final CarDTO carDTO, final Car car) {
        car.setVin(carDTO.getVin());
        car.setMake(carDTO.getMake());
        car.setModel(carDTO.getModel());
        car.setLicensePlateNumber(carDTO.getLicensePlateNumber());
        car.setUserID(carDTO.getUserID());
        return car;
    }

}
