package com.project.authenticator.entities.dto;

import com.project.authenticator.entities.Role;

public record RegisterDTO(String login, String password, Role role) {

}
