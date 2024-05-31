package io.github.navjotsrakhra.appointment_booking.mapper;

import io.github.navjotsrakhra.appointment_booking.domain.UserAccount;
import io.github.navjotsrakhra.appointment_booking.model.request.UserAccountRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserAccountMapper {
  UserAccount userAccountRequestDTOToUserAccount(UserAccountRequestDTO userAccountRequestDTO);
}
