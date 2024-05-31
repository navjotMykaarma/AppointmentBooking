package io.github.navjotsrakhra.appointment_booking.mapper;

import io.github.navjotsrakhra.appointment_booking.domain.Car;
import io.github.navjotsrakhra.appointment_booking.model.CarDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {
  Car carRequestDTOToCar(CarDTO carDTO);

  Car carResponseDTOToCar(CarDTO carDTO);
}
