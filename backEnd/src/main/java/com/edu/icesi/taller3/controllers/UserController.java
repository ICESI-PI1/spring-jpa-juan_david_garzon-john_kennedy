package com.edu.icesi.taller3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.icesi.taller3.persistence.models.Usuario;
import com.edu.icesi.taller3.services.IUserService;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/users")
    public Usuario create(@RequestBody Usuario user) {
        return userService.create(user);
    }

}
