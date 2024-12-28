package com.examen.baseexamen.v1.application.core.user.commands.delete;

import com.examen.baseexamen.v1.application.shared.cqrscore.handlers.commands.GenericDeleteHandler;
import com.examen.baseexamen.v1.infrastructure.entities.DbUser;
import com.examen.baseexamen.v1.infrastructure.repositories.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserDeleteHandler extends GenericDeleteHandler<DbUser, UserDeleteCommand> {

    public UserDeleteHandler(ModelMapper modelMapper, IUserRepository repository) {
        super(modelMapper, repository);
    }
}
