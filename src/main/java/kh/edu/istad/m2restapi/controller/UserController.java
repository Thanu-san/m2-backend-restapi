package kh.edu.istad.m2restapi.controller;

import kh.edu.istad.m2restapi.dto.CreateUserRequest;
import kh.edu.istad.m2restapi.dto.UserResponse;
import kh.edu.istad.m2restapi.model.User;
import kh.edu.istad.m2restapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/paging")
    public Page<UserResponse> getAllWithPaging(
            @RequestParam(required = false, defaultValue = "0") int pageNumber,
            @RequestParam(required = false, defaultValue = "25") int pageSize
    ) {
        return userService.getAllWithPaging(pageNumber, pageSize);
    }

    @GetMapping
    public List<UserResponse> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable UUID id) {
        return userService.getById(id);
    }

    @PostMapping
    public User create(@RequestBody CreateUserRequest createUserRequest) {
        return userService.create(createUserRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        userService.deleteById(id);
    }

}
