package kh.edu.istad.m2restapi.service.impl;

import kh.edu.istad.m2restapi.dto.CreateUserRequest;
import kh.edu.istad.m2restapi.dto.UserResponse;
import kh.edu.istad.m2restapi.mapper.UserMapper;
import kh.edu.istad.m2restapi.model.User;
import kh.edu.istad.m2restapi.repository.UserRepository;
import kh.edu.istad.m2restapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Page<UserResponse> getAllWithPaging(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return userRepository.findAll(pageable)
                .map(userMapper::mapUserToUserResponse);
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::mapUserToUserResponse)
                .toList();
    }

    @Override
    public UserResponse getById(UUID id) {
        return userRepository.findById(id)
                .map(userMapper::mapUserToUserResponse)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "User not found ID :" + id
                ));
    }

    @Override
    public User create(CreateUserRequest createUserRequest) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }
}
