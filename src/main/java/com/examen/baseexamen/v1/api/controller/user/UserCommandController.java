package com.examen.baseexamen.v1.api.controller.user;

import com.examen.baseexamen.v1.application.core.user.commands.UserCommandProcessor;
import com.examen.baseexamen.v1.application.core.user.commands.create.UserCreateCommand;
import com.examen.baseexamen.v1.application.core.user.commands.create.UserCreateOutput;
import com.examen.baseexamen.v1.application.core.user.commands.delete.UserDeleteCommand;
import com.examen.baseexamen.v1.application.core.user.commands.patchRole.UserPatchRoleCommand;
import com.examen.baseexamen.v1.application.core.user.commands.patchRole.UserPatchRoleOutput;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping(path = "{userId}")
    public ResponseEntity<UserPatchRoleOutput> patchRole(
            @PathVariable Long userId,
            @RequestBody UserPatchRoleCommand command
            ) {
        command.id = userId;
        return new ResponseEntity<>(userCommandProcessor.patchRole(command), HttpStatus.OK);
    }


    @DeleteMapping(path = "{userId}")
    public ResponseEntity<Void> delete(@PathVariable Long userId){
        UserDeleteCommand command = new UserDeleteCommand();
        command.id = userId;
        userCommandProcessor.delete(command);
        return ResponseEntity.noContent().build();
    }

}
