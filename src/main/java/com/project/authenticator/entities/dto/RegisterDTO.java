package com.project.authenticator.entities.dto;

import com.project.authenticator.entities.UserRole;

import jakarta.validation.constraints.NotBlank;

public record RegisterDTO(String login, @NotBlank String password, UserRole role) {

}
