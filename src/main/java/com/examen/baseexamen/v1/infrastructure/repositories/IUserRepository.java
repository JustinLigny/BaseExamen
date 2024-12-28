package com.examen.baseexamen.v1.infrastructure.repositories;

import com.examen.baseexamen.v1.application.shared.cqrscore.interfaces.IEntityRepository;
import com.examen.baseexamen.v1.infrastructure.entities.DbUser;

public interface IUserRepository extends IEntityRepository<DbUser> {
    boolean existsByEmail(String email);
    boolean existsByEmailAndIdNot(String email, Long id);

}
