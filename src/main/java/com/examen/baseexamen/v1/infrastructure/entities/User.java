package com.examen.baseexamen.v1.infrastructure.entities;

import com.examen.baseexamen.v1.application.shared.cqrs.entities.DbEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends DbEntity {

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 128, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String role;

}
