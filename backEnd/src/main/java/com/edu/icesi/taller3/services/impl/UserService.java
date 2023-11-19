package com.edu.icesi.taller3.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.edu.icesi.taller3.persistence.models.Usuario;
import com.edu.icesi.taller3.persistence.repositories.UserRepository;
import com.edu.icesi.taller3.services.IUserService;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Usuario create(Usuario user) {
        System.out.println("Creating user: " + user.getUsername() + " " + user.getPassword());
        Usuario user2 = new Usuario();
        user2.setUsername(user.getUsername());
        user2.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user2);
    }

    @Override
    public Usuario findByUsername(String username) {
        return userRepository.findById(username).get();
    }

    @Override
    public List<Usuario> findAll() {
        return userRepository.findAll();
    }

}
