package io.github.navjotsrakhra.appointment_booking.mapper;

import io.github.navjotsrakhra.appointment_booking.domain.Car;
import io.github.navjotsrakhra.appointment_booking.model.request.CarRequestDTO;
import io.github.navjotsrakhra.appointment_booking.model.response.CarResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {
  Car carRequestDTOToCar(CarRequestDTO carDTO);

  Car carResponseDTOToCar(CarResponseDTO carDTO);

  CarResponseDTO carToCarResponseDTO(Car car);
}
