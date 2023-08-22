package org.ucbdev.ecommerceapi.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ucbdev.ecommerceapi.infrastructure.persistence.service.UserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping(path = "create-single-user")
    public void createSingleUser(){
        this.userService.createSingleUser();
    }
}
