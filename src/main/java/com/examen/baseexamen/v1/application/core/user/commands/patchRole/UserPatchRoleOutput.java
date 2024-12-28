package com.examen.baseexamen.v1.application.core.user.commands.patchRole;

import com.examen.baseexamen.v1.application.shared.cqrscore.outputs.EntityOutput;

public class UserPatchRoleOutput extends EntityOutput {
    public String firstName;
    public String lastName;
    public String email;
    public String role;
}
