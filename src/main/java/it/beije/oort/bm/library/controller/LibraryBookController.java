package it.beije.oort.bm.library.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.oort.bm.library.entity.Book;
import it.beije.oort.bm.library.service.BookService;

@RestController
@RequestMapping("/book")
public class LibraryBookController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private BookService bookService;
	
	@GetMapping(value = "/all")
	public List<Book> getAll(){
		log.debug("/book/all : get");
		return bookService.getAll();
	}
	
	@GetMapping(value = "/get/{id}")
	public Book get(@PathVariable int id){
		log.debug("/book/get/{if} : get : id := " + id);
		return bookService.getBook(id);
	}
	
	@PostMapping( value = "/insert")
	public Book insert(@RequestBody Book book) {
		log.debug("/book/insert : post : Object := " + book);
		bookService.addBook(book);
		return book;
	}
	
	@PutMapping( value = "/update/{id}")
	public Book update(@RequestBody Book book, @PathVariable int id){
		log.debug("/book/upgrade/{if} : get : id := " + id + " : Object := " + book);
		return bookService.updateBook(id, book);
	}
	@DeleteMapping( value = "/delete/{id}")
	public boolean delete(@PathVariable int id) {
		log.debug("/book/delete - post - id: " + id);
		return bookService.deleteBook(id);
	}
	
}
