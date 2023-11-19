package com.edu.icesi.taller3.components;

import org.springframework.stereotype.Component;

import com.edu.icesi.taller3.dtos.AuthorDto;
import com.edu.icesi.taller3.persistence.models.Author;

@Component
public class AuthorMapper {

    public AuthorDto toDto(Author author) {
        AuthorDto dto = new AuthorDto();
        dto.setId(author.getId());
        dto.setName(author.getName());
        dto.setNationality(author.getNationality());
        return dto;
    }

    public Author toAuthor(AuthorDto dto) {
        Author author = new Author();
        author.setId(dto.getId());
        author.setName(dto.getName());
        author.setNationality(dto.getNationality());
        return author;
    }

}
