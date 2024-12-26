package com.examen.baseexamen.v1.application.core.user.commands;

import com.examen.baseexamen.v1.application.shared.cqrs.exceptions.EntityAlreadyExistsException;
import com.examen.baseexamen.v1.application.shared.cqrs.interfaces.IValidator;
import com.examen.baseexamen.v1.infrastructure.repositories.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCreateValidator implements IValidator<UserCreateCommand> {

    private final IUserRepository userRepository;

    public UserCreateValidator(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validate(UserCreateCommand input) {
        if(userRepository.existsByEmail(input.email))
            throw new EntityAlreadyExistsException("User already exists with this email: " + input.email);
    }
}
