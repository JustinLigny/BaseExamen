package com.examen.baseexamen.v1.application.core.user.queries.getAll;

import com.examen.baseexamen.v1.application.shared.cqrscore.outputs.EntityGetAllOutput;
import com.examen.baseexamen.v1.application.shared.cqrscore.outputs.EntityOutput;

public class UserGetAllOutput extends EntityGetAllOutput<UserGetAllOutput.User> {

    public static class User extends EntityOutput {
        public String firstName;
        public String lastName;
        public String email;
        public String role;
    }

}
