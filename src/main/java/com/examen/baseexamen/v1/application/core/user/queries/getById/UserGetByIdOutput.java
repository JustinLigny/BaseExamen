package com.examen.baseexamen.v1.application.core.user.queries.getById;

import com.examen.baseexamen.v1.application.shared.cqrscore.outputs.EntityOutput;

public class UserGetByIdOutput extends EntityOutput {
    public String firstName;
    public String lastName;
    public String email;
    public String role;
}
