package com.edu.iceso.taller3;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.edu.icesi.taller3.Taller3Application;
import com.edu.icesi.taller3.persistence.models.Author;
import com.edu.icesi.taller3.persistence.models.Book;
import com.edu.icesi.taller3.persistence.models.Usuario;
import com.edu.icesi.taller3.services.IAuthorService;
import com.edu.icesi.taller3.services.IBookService;
import com.edu.icesi.taller3.services.IUserService;

@SpringBootTest(classes = Taller3Application.class)
class Taller3ApplicationTests {

	@Autowired
	IAuthorService authorService;
	@Autowired
	IBookService bookService;
	@Autowired
	IUserService userService;

	void setUp1() {
		for (Book b : bookService.getAllBooks()) {
			bookService.deleteBook(b.getId());
		}
		for (Author a : authorService.getAllAuthors()) {
			authorService.deleteAuthor(a.getId());
		}
	}

	@Test
	void testCreateUpdateDeleteAuthor() {
		Author author = new Author();
		author.setName("Pepe");
		author.setNationality("Colombia");
		authorService.createAuthor(author);
		Author finded = authorService.getAuthorById(5L).get();
		assertEquals(finded, author);
		finded.setName("Pepito");
		authorService.updateAuthor(5L, finded);
		finded = authorService.getAuthorById(5L).get();
		assertEquals(finded.getName(), "Pepito");
		authorService.deleteAuthor(5L);
		finded = authorService.getAuthorById(5L).orElse(null);
		assertEquals(finded, null);

	}

	@Test
	void testCreateBook() {
		LocalDate date = LocalDate.now();
		Author author4 = new Author(4L, "D", "Colombia");
		Book book = new Book(5L, "Nuevo", date, author4);
		bookService.createBook(book);
		Book finded = bookService.getBookById(5L).get();
		assertEquals(finded, book);
		finded.setTitle("SHELOCK HOLMES");
		bookService.updateBook(5L, finded);
		finded = bookService.getBookById(5L).get();
		assertEquals(finded.getTitle(), "SHELOCK HOLMES");
		assertNotEquals(finded, book);
		bookService.deleteBook(5L);
		finded = bookService.getBookById(5L).orElse(null);
		assertEquals(finded, null);
	}

	@Test
	void testGetAllAuthors() {
		Iterable<Author> authors = authorService.getAllAuthors();
		int i = 0;
		for (Author a : authors) {
			if (a != null) {
				i++;
			}
		}
		assertEquals(i, 4);
	}

	@Test
	void testGetAllBooks() {
		Iterable<Book> books = bookService.getAllBooks();
		int i = 0;
		for (Book b : books) {
			if (b != null) {
				i++;
			}
		}
		assertEquals(i, 4);
	}

	@Test
	void testGetAllBooksByAuthor() {
		Author author = authorService.getAuthorById(1L).get();
		List<Book> books = bookService.findByAuthor(author);
		assertEquals(books.size(), 2);
	}

	@Test
	void createUser() {
		Usuario user = new Usuario("TEST", "TEST");
		userService.create(user);
		Usuario finded = userService.findByUsername("TEST");
		assertEquals(finded.getUsername(), user.getUsername());

	}

}
