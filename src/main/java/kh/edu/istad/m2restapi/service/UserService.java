package kh.edu.istad.m2restapi.service;

import kh.edu.istad.m2restapi.dto.CreateUserRequest;
import kh.edu.istad.m2restapi.dto.UserResponse;
import kh.edu.istad.m2restapi.model.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface UserService {

    Page<UserResponse> getAllWithPaging(int pageNumber, int pageSize);

    List<UserResponse> getAll();

    UserResponse getById(UUID id);

    User create(CreateUserRequest createUserRequest);

    void deleteById(UUID id);
}
