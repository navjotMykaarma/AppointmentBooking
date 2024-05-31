package io.github.navjotsrakhra.appointment_booking.rest;

import io.github.navjotsrakhra.appointment_booking.model.request.PasswordChangeDTO;
import io.github.navjotsrakhra.appointment_booking.model.request.UserAccountRequestDTO;
import io.github.navjotsrakhra.appointment_booking.service.UserService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserResource {
  private final UserService userService;

  public UserResource(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  @ApiResponse(responseCode = "201")
  public ResponseEntity<Long> register(@RequestBody @Valid UserAccountRequestDTO user) {
    Long userId = userService.registerUser(user);

    return new ResponseEntity<>(userId, HttpStatus.CREATED);
  }

  @PostMapping("/password")
  @ApiResponse(responseCode = "200")
  public ResponseEntity<String> changePassword(Principal principal, PasswordChangeDTO passwordChangeDTO) {
    userService.changePassword(principal.getName(), passwordChangeDTO);
    return ResponseEntity.ok().build();
  }
}
