package com.examen.baseexamen.v1.application.core.user.queries.getAll;

import com.examen.baseexamen.v1.application.shared.cqrscore.handlers.queries.GenericGetAllHandler;
import com.examen.baseexamen.v1.infrastructure.entities.DbUser;
import com.examen.baseexamen.v1.infrastructure.repositories.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserGetAllHandler extends GenericGetAllHandler<DbUser, UserGetAllQuery, UserGetAllOutput.User, UserGetAllOutput> {

    public UserGetAllHandler(IUserRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper, UserGetAllOutput.User.class, UserGetAllOutput.class);
    }
}
