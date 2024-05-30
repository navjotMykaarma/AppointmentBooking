package io.github.navjotsrakhra.appointment_booking.rest;

import io.github.navjotsrakhra.appointment_booking.model.CarDTO;
import io.github.navjotsrakhra.appointment_booking.service.CarService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/cars", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarResource {

    private final CarService carService;

    public CarResource(final CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<CarDTO>> getAllCars() {
        return ResponseEntity.ok(carService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCar(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(carService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createCar(@RequestBody @Valid final CarDTO carDTO) {
        final Long createdId = carService.create(carDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateCar(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final CarDTO carDTO) {
        carService.update(id, carDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteCar(@PathVariable(name = "id") final Long id) {
        carService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
