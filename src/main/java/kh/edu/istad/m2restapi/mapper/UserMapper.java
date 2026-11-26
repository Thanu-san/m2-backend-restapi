package kh.edu.istad.m2restapi.mapper;

import kh.edu.istad.m2restapi.dto.UserResponse;
import kh.edu.istad.m2restapi.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse mapUserToUserResponse(User user);
}
