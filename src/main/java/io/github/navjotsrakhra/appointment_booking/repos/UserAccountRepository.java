package io.github.navjotsrakhra.appointment_booking.repos;

import io.github.navjotsrakhra.appointment_booking.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
}
