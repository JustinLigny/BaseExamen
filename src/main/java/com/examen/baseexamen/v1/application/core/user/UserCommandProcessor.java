package com.examen.baseexamen.v1.application.core.user;

import com.examen.baseexamen.v1.application.core.user.commands.UserCreateCommand;
import com.examen.baseexamen.v1.application.core.user.commands.UserCreateOutput;
import com.examen.baseexamen.v1.application.shared.cqrs.interfaces.ICommandHandler;
import org.springframework.stereotype.Service;

@Service
public class UserCommandProcessor {

    private final ICommandHandler<UserCreateCommand, UserCreateOutput> userCreateHandler;

    public UserCommandProcessor(ICommandHandler<UserCreateCommand, UserCreateOutput> userCreateHandler) {
        this.userCreateHandler = userCreateHandler;
    }

    public UserCreateOutput create(UserCreateCommand command){
        return userCreateHandler.handle(command);
    }
}
