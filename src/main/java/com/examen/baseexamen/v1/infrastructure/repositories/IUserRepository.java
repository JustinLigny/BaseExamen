package com.examen.baseexamen.v1.infrastructure.repositories;

import com.examen.baseexamen.v1.application.shared.cqrs.interfaces.IEntityRepository;
import com.examen.baseexamen.v1.infrastructure.entities.User;

public interface IUserRepository extends IEntityRepository<User> {
    boolean existsByEmail(String email);
}
