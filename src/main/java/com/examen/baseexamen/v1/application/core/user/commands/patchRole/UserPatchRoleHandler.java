package com.examen.baseexamen.v1.application.core.user.commands.patchRole;

import com.examen.baseexamen.v1.application.shared.cqrscore.handlers.commands.GenericPutHandler;
import com.examen.baseexamen.v1.domain.User;
import com.examen.baseexamen.v1.infrastructure.entities.DbUser;
import com.examen.baseexamen.v1.infrastructure.repositories.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserPatchRoleHandler extends GenericPutHandler<User, DbUser, UserPatchRoleCommand, UserPatchRoleOutput> {

    public UserPatchRoleHandler(ModelMapper modelMapper, IUserRepository repository) {
        super(modelMapper, User.class, repository, UserPatchRoleOutput.class);
    }
}
