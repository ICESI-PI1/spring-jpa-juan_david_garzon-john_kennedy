package com.edu.icesi.taller3.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edu.icesi.taller3.dtos.BookDto;
import com.edu.icesi.taller3.persistence.models.Book;

@Component
public class BookMapper {
    @Autowired
    private AuthorMapper authorMapper;

    public BookDto toDto(Book book) {
        BookDto dto = new BookDto();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setReleaseDate(book.getReleaseDate());
        dto.setAuthor(authorMapper.toDto(book.getAuthor()));
        return dto;
    }

    public Book toBook(BookDto dto) {
        Book book = new Book();
        book.setId(dto.getId());
        book.setTitle(dto.getTitle());
        book.setReleaseDate(dto.getReleaseDate());
        book.setAuthor(authorMapper.toAuthor(dto.getAuthor()));
        return book;
    }

}
