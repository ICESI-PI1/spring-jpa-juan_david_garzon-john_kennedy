package com.edu.icesi.taller3.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.icesi.taller3.persistence.models.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
