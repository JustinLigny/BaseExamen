package com.examen.baseexamen.v1.api.controller.user;

import com.examen.baseexamen.v1.application.core.user.queries.UserQueryProcessor;
import com.examen.baseexamen.v1.application.core.user.queries.getById.UserGetByIdOutput;
import com.examen.baseexamen.v1.application.core.user.queries.getById.UserGetByIdQuery;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "users")
@RequestMapping("v1/users")
public class UserQueryController {

    private final UserQueryProcessor userQueryProcessor;

    public UserQueryController(UserQueryProcessor userQueryProcessor) {
        this.userQueryProcessor = userQueryProcessor;
    }

    @GetMapping(path = "{userId}")
    public UserGetByIdOutput getById(@PathVariable Long userId){
        UserGetByIdQuery query = new UserGetByIdQuery();
        query.id = userId;
        return userQueryProcessor.getById(query);
    }
}
