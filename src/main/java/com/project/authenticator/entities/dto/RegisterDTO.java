package com.project.authenticator.entities.dto;

import com.project.authenticator.entities.Role;

import jakarta.validation.constraints.NotBlank;

public record RegisterDTO(String login, @NotBlank String password, Role role) {

}
