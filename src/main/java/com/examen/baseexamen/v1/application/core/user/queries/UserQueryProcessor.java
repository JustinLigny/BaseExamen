package com.examen.baseexamen.v1.application.core.user.queries;

import com.examen.baseexamen.v1.application.core.user.queries.getAll.UserGetAllOutput;
import com.examen.baseexamen.v1.application.core.user.queries.getAll.UserGetAllQuery;
import com.examen.baseexamen.v1.application.core.user.queries.getById.UserGetByIdOutput;
import com.examen.baseexamen.v1.application.core.user.queries.getById.UserGetByIdQuery;
import com.examen.baseexamen.v1.application.shared.cqrscore.interfaces.IQueryHandler;
import org.springframework.stereotype.Service;

@Service
public class UserQueryProcessor {

    private final IQueryHandler<UserGetByIdQuery, UserGetByIdOutput> userGetByIdHandler;
    private final IQueryHandler<UserGetAllQuery, UserGetAllOutput> userGetAllHandler;

    public UserQueryProcessor(IQueryHandler<UserGetByIdQuery, UserGetByIdOutput> userGetByIdHandler, IQueryHandler<UserGetAllQuery, UserGetAllOutput> userGetAllHandler) {
        this.userGetByIdHandler = userGetByIdHandler;
        this.userGetAllHandler = userGetAllHandler;
    }

    public UserGetByIdOutput getById(UserGetByIdQuery query){
        return userGetByIdHandler.handle(query);
    }

    public UserGetAllOutput getAll(UserGetAllQuery query) {
        return userGetAllHandler.handle(query);
    }

}
