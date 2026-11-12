package kh.edu.istad.m2restapi.service.impl;

import kh.edu.istad.m2restapi.dto.CreateUserRequest;
import kh.edu.istad.m2restapi.model.User;
import kh.edu.istad.m2restapi.repository.UserRepository;
import kh.edu.istad.m2restapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.selectAll();
    }

    @Override
    public User getById(UUID id) {
        return userRepository.selectById(id)
                .orElseThrow();
    }

    @Override
    public User create(CreateUserRequest createUserRequest) {
        User user = new User(
                UUID.randomUUID(),
                createUserRequest.name(),
                createUserRequest.username(),
                createUserRequest.password(),
                true
        );
        userRepository.insert(user);
        return user;
    }

    @Override
    public void deleteById(UUID id) {
        User user = getById(id);
        userRepository.deleteById(user.getId());
    }
}
