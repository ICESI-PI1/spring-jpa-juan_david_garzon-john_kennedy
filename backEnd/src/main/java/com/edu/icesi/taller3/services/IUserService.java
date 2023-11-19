package com.edu.icesi.taller3.services;

import java.util.List;

import com.edu.icesi.taller3.persistence.models.Usuario;

public interface IUserService {

    Usuario create(Usuario user);

    Usuario findByUsername(String username);

    List<Usuario> findAll();

}
