package com.examen.baseexamen.v1.application.core.user.commands.create;

import com.examen.baseexamen.v1.application.shared.cqrscore.handlers.commands.GenericCreateHandler;
import com.examen.baseexamen.v1.application.shared.cqrscore.interfaces.IEntityRepository;
import com.examen.baseexamen.v1.application.shared.cqrscore.interfaces.IValidator;
import com.examen.baseexamen.v1.domain.User;
import com.examen.baseexamen.v1.infrastructure.entities.DbUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCreateHandler extends GenericCreateHandler<User, DbUser, UserCreateCommand, UserCreateOutput> {

    private final PasswordEncoder passwordEncoder;

    public UserCreateHandler(ModelMapper modelMapper, IEntityRepository<DbUser> repository, IValidator<UserCreateCommand> validator, PasswordEncoder passwordEncoder) {
        super(modelMapper, User.class, DbUser.class, repository, UserCreateOutput.class);
        super.setValidator(validator);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void beforeEntitySave(DbUser entityDatabase) {
        String passwordHashed = passwordEncoder.encode(entityDatabase.getPassword());
        entityDatabase.setPassword(passwordHashed);
    }
}
