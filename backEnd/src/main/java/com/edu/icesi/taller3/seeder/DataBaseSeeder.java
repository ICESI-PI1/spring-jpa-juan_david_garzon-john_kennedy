package com.edu.icesi.taller3.seeder;

import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import com.edu.icesi.taller3.persistence.models.Author;
import com.edu.icesi.taller3.persistence.models.Book;
import com.edu.icesi.taller3.persistence.models.Usuario;
import com.edu.icesi.taller3.persistence.repositories.AuthorRepository;
import com.edu.icesi.taller3.persistence.repositories.BookRepository;
import com.edu.icesi.taller3.services.impl.UserService;

import org.slf4j.Logger;

@Component
public class DataBaseSeeder {
    private Logger logger = LoggerFactory.getLogger(DataBaseSeeder.class);
    @Autowired
    public AuthorRepository authorRepository;
    @Autowired
    public BookRepository bookRepository;
    @Autowired
    public UserService userService;

    public DataBaseSeeder(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedUser();
        seedAuthors();
        seedBooks();
    }

    public void seedUser() {
        List<Usuario> users = userService.findAll();
        if (users.isEmpty()) {
            Usuario user = new Usuario("admin", "admin");
            userService.create(user);
        } else {
            logger.trace("User Seeding Not Required");
            return;
        }

    }

    public void seedAuthors() {
        List<Author> authors = authorRepository.findAll();
        if (authors.isEmpty()) {
            Author author1 = new Author(1L, "A", "Colombia");
            Author author2 = new Author(2L, "B", "Colombia");
            Author author3 = new Author(3L, "C", "Colombia");
            Author author4 = new Author(4L, "D", "Colombia");
            authorRepository.save(author1);
            authorRepository.save(author2);
            authorRepository.save(author3);
            authorRepository.save(author4);

        } else {
            logger.trace("Author Seeding Not Required");
        }

    }

    public void seedBooks() {
        List<Book> books = bookRepository.findAll();
        if (books.isEmpty()) {
            Author author1 = new Author(1L, "A", "Colombia");
            Author author2 = new Author(2L, "B", "Colombia");
            Author author3 = new Author(3L, "C", "Colombia");
            Book book1 = new Book(1L, "primero", LocalDate.now(), author1);
            Book book2 = new Book(2L, "Segundo", LocalDate.now(), author1);
            Book book3 = new Book(3L, "Tercero", LocalDate.now(), author2);
            Book book4 = new Book(4L, "Cuarto", LocalDate.now(), author3);
            bookRepository.save(book1);
            bookRepository.save(book2);
            bookRepository.save(book3);
            bookRepository.save(book4);

        } else {
            logger.trace("Books Seeding Not Required");
        }
    }

}
