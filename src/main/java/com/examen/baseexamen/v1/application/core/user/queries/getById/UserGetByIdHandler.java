package com.examen.baseexamen.v1.application.core.user.queries.getById;

import com.examen.baseexamen.v1.application.shared.cqrs.handlers.queries.GenericGetByIdHandler;
import com.examen.baseexamen.v1.infrastructure.entities.DbUser;
import com.examen.baseexamen.v1.infrastructure.repositories.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserGetByIdHandler extends GenericGetByIdHandler<DbUser, UserGetByIdQuery, UserGetByIdOutput> {

    public UserGetByIdHandler(IUserRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper, UserGetByIdOutput.class);
    }

}
