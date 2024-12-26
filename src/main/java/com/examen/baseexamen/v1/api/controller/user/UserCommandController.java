package com.examen.baseexamen.v1.api.controller.user;

import com.examen.baseexamen.v1.application.core.user.commands.UserCommandProcessor;
import com.examen.baseexamen.v1.application.core.user.commands.create.UserCreateCommand;
import com.examen.baseexamen.v1.application.core.user.commands.create.UserCreateOutput;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "users")
@RequestMapping("v1/users")
public class UserCommandController {

    private final UserCommandProcessor userCommandProcessor;

    public UserCommandController(UserCommandProcessor userCommandProcessor) {
        this.userCommandProcessor = userCommandProcessor;
    }

    @PostMapping
    public ResponseEntity<UserCreateOutput> create(@RequestBody UserCreateCommand command){
        return new ResponseEntity<>(userCommandProcessor.create(command), HttpStatus.CREATED);
    }

}
