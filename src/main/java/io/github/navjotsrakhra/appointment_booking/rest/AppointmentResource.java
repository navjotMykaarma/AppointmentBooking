package io.github.navjotsrakhra.appointment_booking.rest;

import io.github.navjotsrakhra.appointment_booking.model.AppointmentDTO;
import io.github.navjotsrakhra.appointment_booking.model.Role;
import io.github.navjotsrakhra.appointment_booking.service.AppointmentService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.annotation.security.RolesAllowed;
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
@RequestMapping(value = "/api/appointments", produces = MediaType.APPLICATION_JSON_VALUE)
public class AppointmentResource {

  private final AppointmentService appointmentService;

  public AppointmentResource(final AppointmentService appointmentService) {
    this.appointmentService = appointmentService;
  }

  @GetMapping
  public ResponseEntity<List<AppointmentDTO>> getAllAppointments() { // TODO Paginate
    return ResponseEntity.ok(appointmentService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<AppointmentDTO> getAppointment(@PathVariable(name = "id") final Long id) {
    return ResponseEntity.ok(appointmentService.get(id));
  }

  @PostMapping
  @ApiResponse(responseCode = "201")
  public ResponseEntity<Long> createAppointment(
    @RequestBody @Valid final AppointmentDTO appointmentDTO) {
    final Long createdId = appointmentService.create(appointmentDTO);
    return new ResponseEntity<>(createdId, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Long> updateAppointment(@PathVariable(name = "id") final Long id,
                                                @RequestBody @Valid final AppointmentDTO appointmentDTO) {
    appointmentService.update(id, appointmentDTO);
    return ResponseEntity.ok(id);
  }

  @DeleteMapping("/{id}")
  @ApiResponse(responseCode = "204")
  public ResponseEntity<Void> deleteAppointment(@PathVariable(name = "id") final Long id) {
    appointmentService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
