package kh.edu.istad.m2restapi.dto;

public record CreateUserRequest(
        String name,
        String username,
        String password
) {
}
