package com.examen.baseexamen.v1.application.core.user.commands.create;

import com.examen.baseexamen.v1.application.shared.cqrscore.outputs.EntityOutput;

public class UserCreateOutput extends EntityOutput {
    public String firstName;
    public String lastName;
    public String email;
    public String role;
}
