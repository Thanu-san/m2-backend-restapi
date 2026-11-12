package kh.edu.istad.m2restapi.service;

import kh.edu.istad.m2restapi.dto.CreateUserRequest;
import kh.edu.istad.m2restapi.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<User> getAll();

    User getById(UUID id);

    User create(CreateUserRequest createUserRequest);

    void deleteById(UUID id);
}
