package it.beije.oort.bm.library.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.beije.oort.bm.library.entity.Author;
import it.beije.oort.bm.library.entity.Book;
import it.beije.oort.bm.library.entity.Publisher;
import it.beije.oort.bm.library.service.AuthorService;
import it.beije.oort.bm.library.service.BookService;
import it.beije.oort.bm.library.service.PublisherService;

@Controller
public class LibraryBookController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private BookService bookService;
	@Autowired
	private AuthorService authorService;
	@Autowired
	private PublisherService publisherService;
	
	@RequestMapping( value = "/book/insert", method = RequestMethod.POST)
	public void insert(Book book, HttpServletRequest req, HttpServletResponse resp, Model model) {
		Author a = authorService.getAuthor(Integer.parseInt(req.getParameter("author_id")));
		Publisher p = publisherService.getPublisher(Integer.parseInt(req.getParameter("publisher_id")));
		book.setAuthor(a);
		book.setPublisher(p);
		log.debug("/book/insert - post - Object: " + book);
		boolean result = bookService.addBook(book);
		if(!result) model.addAttribute("insertMsg", "We got a problem adding the Book.");
		try {
			resp.sendRedirect("../books");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping( value = "/book/delete", method = RequestMethod.POST)
	public void delete(HttpServletRequest req, HttpServletResponse resp, Model model) {
		int id = Integer.parseInt(req.getParameter("del_id"));
		log.debug("/book/delete - post - id: " + id);
		boolean result = bookService.deleteBook(id);
		if(result) model.addAttribute("deleteMsg", "Requested book has been deleted successfully.");
		else model.addAttribute("deleteMsg", "Impossible to delete the requested book, it's a masterpiece!");
		try {
			resp.sendRedirect("../books");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
