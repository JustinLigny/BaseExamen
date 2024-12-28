package com.examen.baseexamen.v1.application.core.user.commands;

import com.examen.baseexamen.v1.application.core.user.commands.create.UserCreateCommand;
import com.examen.baseexamen.v1.application.core.user.commands.create.UserCreateOutput;
import com.examen.baseexamen.v1.application.core.user.commands.delete.UserDeleteCommand;
import com.examen.baseexamen.v1.application.core.user.commands.patchRole.UserPatchRoleCommand;
import com.examen.baseexamen.v1.application.core.user.commands.patchRole.UserPatchRoleOutput;
import com.examen.baseexamen.v1.application.shared.cqrscore.interfaces.ICommandHandler;
import com.examen.baseexamen.v1.application.shared.cqrscore.interfaces.ICommandWithoutResponseHandler;
import org.springframework.stereotype.Service;

@Service
public class UserCommandProcessor {

    private final ICommandHandler<UserCreateCommand, UserCreateOutput> userCreateHandler;
    private final ICommandHandler<UserPatchRoleCommand, UserPatchRoleOutput> userPatchRoleHandler;
    private final ICommandWithoutResponseHandler<UserDeleteCommand> userDeleteHandler;

    public UserCommandProcessor(ICommandHandler<UserCreateCommand, UserCreateOutput> userCreateHandler, ICommandHandler<UserPatchRoleCommand, UserPatchRoleOutput> userPatchRoleHandler, ICommandWithoutResponseHandler<UserDeleteCommand> userDeleteHandler) {
        this.userCreateHandler = userCreateHandler;
        this.userPatchRoleHandler = userPatchRoleHandler;
        this.userDeleteHandler = userDeleteHandler;
    }

    public UserCreateOutput create(UserCreateCommand command){
        return userCreateHandler.handle(command);
    }

    public UserPatchRoleOutput patchRole(UserPatchRoleCommand command){
        return userPatchRoleHandler.handle(command);
    }
    public void delete(UserDeleteCommand command) {
        userDeleteHandler.handle(command);
    }

}
