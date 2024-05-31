package io.github.navjotsrakhra.appointment_booking.dao;

import io.github.navjotsrakhra.appointment_booking.domain.UserAccount;
import io.github.navjotsrakhra.appointment_booking.repos.UserAccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserAccountDao implements Dao<UserAccount>, PagingDao<UserAccount> {
  private final UserAccountRepository userAccountRepository;

  public UserAccountDao(UserAccountRepository userAccountRepository) {
    this.userAccountRepository = userAccountRepository;
  }

  @Override
  public UserAccount save(UserAccount userAccount) {
    return this.userAccountRepository.save(userAccount);
  }

  @Override
  public UserAccount update(UserAccount userAccount) {
    return this.userAccountRepository.save(userAccount);
  }

  @Override
  public UserAccount delete(UserAccount userAccount) {
    this.userAccountRepository.delete(userAccount);
    return userAccount;
  }

  @Override
  public Optional<UserAccount> findById(Long id) {
    return this.userAccountRepository.findById(id);
  }

  @Override
  public List<UserAccount> findAll() {
    return this.userAccountRepository.findAll();
  }

  public Optional<UserAccount> findByUsername(String username) {
    return userAccountRepository.findByUsername(username);
  }

  @Override
  public Page<UserAccount> findAll(Pageable pageable) {
    return this.userAccountRepository.findAll(pageable);
  }
}
