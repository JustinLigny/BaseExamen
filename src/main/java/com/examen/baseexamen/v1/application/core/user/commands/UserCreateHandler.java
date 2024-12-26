package com.examen.baseexamen.v1.application.core.user.commands;

import com.examen.baseexamen.v1.application.shared.cqrs.handlers.commands.GenericCreateHandler;
import com.examen.baseexamen.v1.application.shared.cqrs.interfaces.IEntityRepository;
import com.examen.baseexamen.v1.application.shared.cqrs.interfaces.IValidator;
import com.examen.baseexamen.v1.infrastructure.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserCreateHandler extends GenericCreateHandler<com.examen.baseexamen.v1.domain.User, User, com.examen.baseexamen.v1.application.core.user.commands.UserCreateCommand, UserCreateOutput> {

    public UserCreateHandler(ModelMapper modelMapper, IEntityRepository<User> repository, IValidator<UserCreateCommand> validator) {
        super(modelMapper, com.examen.baseexamen.v1.domain.User.class, User.class, repository, UserCreateOutput.class);
        super.setValidator(validator);
    }
}
