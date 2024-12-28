package com.examen.baseexamen.v1.application.core.user.commands.create;

import com.examen.baseexamen.v1.application.shared.cqrscore.commands.EntityCommand;

public class UserCreateCommand extends EntityCommand {
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String role;
}
