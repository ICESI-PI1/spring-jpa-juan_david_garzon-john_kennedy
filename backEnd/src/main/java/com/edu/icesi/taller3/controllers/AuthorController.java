package com.edu.icesi.taller3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.icesi.taller3.components.AuthorMapper;
import com.edu.icesi.taller3.components.BookMapper;
import com.edu.icesi.taller3.dtos.AuthorDto;
import com.edu.icesi.taller3.dtos.BookDto;
import com.edu.icesi.taller3.persistence.models.Author;
import com.edu.icesi.taller3.persistence.models.Book;
import com.edu.icesi.taller3.services.IAuthorService;
import com.edu.icesi.taller3.services.IBookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class AuthorController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IAuthorService authorService;
    @Autowired
    private AuthorMapper authorMapper;
    @Autowired
    private BookMapper bookMapper;

    @GetMapping("/autores")
    public List<AuthorDto> getAllAuthors() {
        List<AuthorDto> authors = new ArrayList<>();
        authorService.getAllAuthors();
        for (Author a : authorService.getAllAuthors()) {
            authors.add(authorMapper.toDto(a));
        }
        return authors;
    }

    @GetMapping("/autores/{id}")
    public Optional<AuthorDto> getAuthorById(@PathVariable Long id) {
        Optional<Author> a = authorService.getAuthorById(id);
        return Optional.of(authorMapper.toDto(a.get()));
    }

    @PostMapping("/autores")
    public AuthorDto createAuthor(@RequestBody AuthorDto author) {
        return authorMapper.toDto(authorService.createAuthor(authorMapper.toAuthor(author)));
    }

    @PutMapping("/autores/{id}")
    public Optional<AuthorDto> updateAuthor(@PathVariable Long id, @RequestBody AuthorDto updatedAuthor) {

        return Optional
                .of(authorMapper.toDto(authorService.updateAuthor(id, authorMapper.toAuthor(updatedAuthor)).get()));
    }

    @DeleteMapping("/autores/{id}")
    public boolean deleteAuthor(@PathVariable Long id) {
        return authorService.deleteAuthor(id);
    }

    @GetMapping("/libros")
    public List<BookDto> getAllLBooks() {
        List<BookDto> books = new ArrayList<>();
        for (Book b : bookService.getAllBooks()) {
            books.add(bookMapper.toDto(b));
        }
        return books;
    }

    @GetMapping("/libros/{id}")
    public Optional<BookDto> getBookById(@PathVariable Long id) {
        return Optional.of(bookMapper.toDto(bookService.getBookById(id).get()));
    }

    @PostMapping("/libros")
    public BookDto createBook(@RequestBody BookDto book) {
        return bookMapper.toDto(bookService.createBook(bookMapper.toBook(book)));
    }

    @PutMapping("/libros/{id}")
    public Optional<BookDto> updateBook(@PathVariable Long id, @RequestBody BookDto updatedBook) {
        return Optional.of(bookMapper.toDto(bookService.updateBook(id, bookMapper.toBook(updatedBook)).get()));
    }

    @DeleteMapping("/libros/{id}")
    public boolean deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }

    @GetMapping("/libros/{id}/authors")
    public List<BookDto> getAuthorsByBookId(@PathVariable Long id) {
        Author author = authorService.getAuthorById(id).get();
        List<Book> finded = bookService.findByAuthor(author);
        List<BookDto> books = new ArrayList<>();
        for (Book b : finded) {
            books.add(bookMapper.toDto(b));
        }
        return books;
    }

}
