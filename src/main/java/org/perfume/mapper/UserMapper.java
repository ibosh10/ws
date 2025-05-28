package org.perfume.mapper;

import org.perfume.domain.entity.User;
import org.perfume.model.dto.request.RegisterRequest;
import org.perfume.model.dto.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements EntityMapper<User, UserResponse> {

    @Override
    public UserResponse toDto(User entity) {
        if (entity == null) {
            return null;
        }

        return new UserResponse(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPhoneNumber(),
                entity.getRole(),
                entity.isGoogleUser()
        );
    }

    @Override
    public User toEntity(UserResponse dto) {
        if (dto == null) {
            return null;
        }

        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setRole(dto.getRole());
        user.setGoogleUser(dto.isGoogleUser());
        return user;
    }

    public User toEntity(RegisterRequest request) {
        if (request == null) {
            return null;
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhoneNumber(request.getPhoneNumber());
        return user;
    }
}