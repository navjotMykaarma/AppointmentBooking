package io.github.navjotsrakhra.appointment_booking.service;

import io.github.navjotsrakhra.appointment_booking.dao.UserAccountDao;
import io.github.navjotsrakhra.appointment_booking.domain.UserAccount;
import io.github.navjotsrakhra.appointment_booking.mapper.UserAccountMapper;
import io.github.navjotsrakhra.appointment_booking.model.Role;
import io.github.navjotsrakhra.appointment_booking.model.request.PasswordChangeDTO;
import io.github.navjotsrakhra.appointment_booking.model.request.UserAccountRequestDTO;
import io.github.navjotsrakhra.appointment_booking.repos.UserAccountRepository;
import io.github.navjotsrakhra.appointment_booking.util.exception.UsernameAlreadyTakenException;
import io.github.navjotsrakhra.appointment_booking.util.exception.WrongPasswordException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
  private final PasswordEncoder passwordEncoder;
  private final UserAccountDao userAccountDao;
  private final UserAccountMapper userAccountMapper;

  public UserService(PasswordEncoder passwordEncoder, UserAccountDao userAccountDao, UserAccountMapper userAccountMapper, UserAccountRepository repository) {
    this.passwordEncoder = passwordEncoder;
    this.userAccountDao = userAccountDao;
    this.userAccountMapper = userAccountMapper;
  }

  public Long registerUser(UserAccountRequestDTO userAccountRequestDTO) {
    Objects.requireNonNull(userAccountRequestDTO);

    UserAccount userAccount = userAccountMapper.userAccountRequestDTOToUserAccount(userAccountRequestDTO);

    userAccountDao
      .findByUsername(userAccount.getUsername())
      .ifPresent(
        __ -> {
          throw new UsernameAlreadyTakenException("Username already taken.");
        }
      );
    // If username isn't taken
    userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
    userAccount.setAccountExpired(false);
    userAccount.setAccountLocked(false);
    userAccount.setCredentialsExpired(false);
    userAccount.setRoles(
      new ArrayList<>(
        List.of(Role.USER)
      )
    );

    userAccount = userAccountDao.save(userAccount);

    return userAccount.getId();
  }

  public void changePassword(String username, PasswordChangeDTO passwordChangeDTO) {
    Objects.requireNonNull(username);
    Objects.requireNonNull(passwordChangeDTO);

    Optional<UserAccount> user = userAccountDao.findByUsername(username);
    UserAccount userAccount = user.orElseThrow(() -> new UsernameNotFoundException("Username not found.")); // Shouldn't occur ever. Only if user deletes account and somehow stays logged in.

    String currentEncodedPassword = passwordEncoder.encode(passwordChangeDTO.getCurrentPassword());

    if (currentEncodedPassword.equals(userAccount.getPassword())) {
      userAccount.setPassword(passwordEncoder.encode(passwordChangeDTO.getNewPassword()));
      userAccountDao.save(userAccount);
    } else {
      throw new WrongPasswordException("Wrong password.");
    }
  }
}
