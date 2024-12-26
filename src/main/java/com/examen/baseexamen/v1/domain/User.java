package com.examen.baseexamen.v1.domain;

import com.examen.baseexamen.v1.application.shared.cqrs.domain.Entity;
import com.examen.baseexamen.v1.application.shared.cqrs.exceptions.IllegalArgumentException;
import io.micrometer.common.util.StringUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class User extends Entity {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;

    public void setFirstName(String firstName) {
        if (StringUtils.isBlank(firstName))
            throw new IllegalArgumentException("firstName", "First name cannot be empty");
        if (firstName.length() > 50)
            throw new IllegalArgumentException("firstName", "First name cannot be longer than 50 chars");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (StringUtils.isBlank(lastName))
            throw new IllegalArgumentException("lastName", "Last name cannot be empty");
        if (lastName.length() > 50)
            throw new IllegalArgumentException("lastName", "Last name cannot be longer than 50 chars");
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        if (StringUtils.isBlank(email))
            throw new IllegalArgumentException("email", "Email cannot be blank");
        if(email.length() > 100)
            throw new IllegalArgumentException("email", "Email cannot be longer than 100 chars");
        this.email = email;
    }

    public void setPassword(String password) {
        if (StringUtils.isBlank(password))
            throw new IllegalArgumentException("password", "Password cannot be empty");
        if (password.length() < 12) {
            throw new IllegalArgumentException("password", "Password must be at least 12 characters long");
        }
        if (password.length() > 128) {
            throw new IllegalArgumentException("password", "Password cannot be longer than 128 characters");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("password", "Password must contain at least one uppercase letter");
        }
        if (!password.matches(".*[a-z].*")) {
            throw new IllegalArgumentException("password", "Password must contain at least one lowercase letter");
        }
        if (!password.matches(".*\\d.*")) {
            throw new IllegalArgumentException("password", "Password must contain at least one digit");
        }
        this.password = password;
    }

    public void setRole(String role) {
        List<String> roles = Arrays.asList("USER", "ADMIN");
        role = role.toUpperCase();
        if (StringUtils.isBlank(role))
            throw new IllegalArgumentException("role", "Role cannot be empty");
        if(!roles.contains(role))
            throw new IllegalArgumentException("role", "Role must be either USER or ADMIN");
        this.role = role;
    }
}
