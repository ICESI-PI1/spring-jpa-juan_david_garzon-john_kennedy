package com.edu.icesi.taller3.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.icesi.taller3.persistence.models.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, String> {

}
