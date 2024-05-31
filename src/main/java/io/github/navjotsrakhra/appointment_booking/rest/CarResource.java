package io.github.navjotsrakhra.appointment_booking.rest;

import io.github.navjotsrakhra.appointment_booking.model.request.CarRequestDTO;
import io.github.navjotsrakhra.appointment_booking.model.response.CarResponseDTO;
import io.github.navjotsrakhra.appointment_booking.service.CarService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/cars", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarResource {

  private final CarService carService;

  public CarResource(final CarService carService) {
    this.carService = carService;
  }

  @GetMapping
  public ResponseEntity<List<CarResponseDTO>> getAllCars() {
    return ResponseEntity.ok(carService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<CarResponseDTO> getCar(@PathVariable(name = "id") final Long id) {
    return ResponseEntity.ok(carService.get(id));
  }

  @PostMapping
  @ApiResponse(responseCode = "201")
  public ResponseEntity<Long> createCar(@RequestBody @Valid final CarRequestDTO carRequestDTO) {
    final Long createdId = carService.create(carRequestDTO);
    return new ResponseEntity<>(createdId, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Long> updateCar(@PathVariable(name = "id") final Long id, @RequestBody @Valid final CarRequestDTO carRequestDTO) {
    carService.update(id, carRequestDTO);
    return ResponseEntity.ok(id);
  }

  @DeleteMapping("/{id}")
  @ApiResponse(responseCode = "204")
  public ResponseEntity<Void> deleteCar(@PathVariable(name = "id") final Long id) {
    carService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
