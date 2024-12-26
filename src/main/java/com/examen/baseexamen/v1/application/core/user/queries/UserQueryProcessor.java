package com.examen.baseexamen.v1.application.core.user.queries;

import com.examen.baseexamen.v1.application.core.user.queries.getById.UserGetByIdOutput;
import com.examen.baseexamen.v1.application.core.user.queries.getById.UserGetByIdQuery;
import com.examen.baseexamen.v1.application.shared.cqrs.interfaces.IQueryHandler;
import org.springframework.stereotype.Service;

@Service
public class UserQueryProcessor {

    private final IQueryHandler<UserGetByIdQuery, UserGetByIdOutput> userGetByIdHandler;

    public UserQueryProcessor(IQueryHandler<UserGetByIdQuery, UserGetByIdOutput> userGetByIdHandler) {
        this.userGetByIdHandler = userGetByIdHandler;
    }

    public UserGetByIdOutput getById(UserGetByIdQuery query){
        return userGetByIdHandler.handle(query);
    }

}
