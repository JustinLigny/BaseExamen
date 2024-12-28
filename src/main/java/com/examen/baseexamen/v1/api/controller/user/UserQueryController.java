package com.examen.baseexamen.v1.api.controller.user;

import com.examen.baseexamen.v1.application.core.user.queries.UserQueryProcessor;
import com.examen.baseexamen.v1.application.core.user.queries.getAll.UserGetAllOutput;
import com.examen.baseexamen.v1.application.core.user.queries.getAll.UserGetAllQuery;
import com.examen.baseexamen.v1.application.core.user.queries.getById.UserGetByIdOutput;
import com.examen.baseexamen.v1.application.core.user.queries.getById.UserGetByIdQuery;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<UserGetAllOutput.User>> getAll(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "id") String sortBy,
            @RequestParam(required = false, defaultValue = "asc") String sortDirection
    ){
        UserGetAllQuery query = new UserGetAllQuery();
        query.page = page;
        query.size = size;
        query.sortBy = sortBy;
        query.sortDirection = sortDirection;
        return new ResponseEntity<>(userQueryProcessor.getAll(query).entities, HttpStatus.OK);
    }
}
