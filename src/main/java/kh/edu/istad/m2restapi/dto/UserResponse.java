package kh.edu.istad.m2restapi.dto;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String name,
        Boolean isActive
) {

}
