package io.github.navjotsrakhra.appointment_booking.rest;

import io.github.navjotsrakhra.appointment_booking.model.request.AppointmentRequestDTO;
import io.github.navjotsrakhra.appointment_booking.model.response.AppointmentResponseDTO;
import io.github.navjotsrakhra.appointment_booking.service.AppointmentService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@RequestMapping(value = "/api/appointments", produces = MediaType.APPLICATION_JSON_VALUE)
public class AppointmentResource {

  private final AppointmentService appointmentService;

  public AppointmentResource(final AppointmentService appointmentService) {
    this.appointmentService = appointmentService;
  }

  @Cacheable(value = "appointmentCache")
  @GetMapping
  public ResponseEntity<Page<AppointmentResponseDTO>> getAllAppointments(@PageableDefault(size = 15, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
    return ResponseEntity.ok(appointmentService.findAll(pageable));
  }

  @GetMapping("/{id}")
  public ResponseEntity<AppointmentResponseDTO> getAppointment(@PathVariable(name = "id") final Long id) {
    return ResponseEntity.ok(appointmentService.get(id));
  }

  @PostMapping
  @ApiResponse(responseCode = "201")
  @CacheEvict(value = "appointmentCache")
  public ResponseEntity<Long> createAppointment(
    @RequestBody @Valid final AppointmentRequestDTO appointmentRequestDTO, Principal principal) {
    final Long createdId = appointmentService.create(principal.getName(), appointmentRequestDTO);
    return new ResponseEntity<>(createdId, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  @CacheEvict(value = "appointmentCache")
  public ResponseEntity<Long> updateAppointment(@PathVariable(name = "id") final Long id,
                                                @RequestBody @Valid final AppointmentRequestDTO appointmentRequestDTO) {
    appointmentService.update(id, appointmentRequestDTO);
    return ResponseEntity.ok(id);
  }

  @DeleteMapping("/{id}")
  @CacheEvict(value = "appointmentCache")
  @ApiResponse(responseCode = "204")
  public ResponseEntity<Void> deleteAppointment(@PathVariable(name = "id") final Long id) {
    appointmentService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
