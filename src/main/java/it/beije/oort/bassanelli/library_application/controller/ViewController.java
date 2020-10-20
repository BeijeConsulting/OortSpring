package it.beije.oort.bassanelli.library_application.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.bassanelli.library_application.entity.Author;
import it.beije.oort.bassanelli.library_application.entity.Book;
import it.beije.oort.bassanelli.library_application.entity.Borrow;
import it.beije.oort.bassanelli.library_application.entity.Publisher;
import it.beije.oort.bassanelli.library_application.entity.User;
import it.beije.oort.bassanelli.library_application.service.AuthorService;
import it.beije.oort.bassanelli.library_application.service.BookService;
import it.beije.oort.bassanelli.library_application.service.BorrowService;
import it.beije.oort.bassanelli.library_application.service.PublisherService;

@Controller
public class ViewController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	private static final String root = "/library";
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private PublisherService publisherService;
	
	@Autowired
	private BorrowService borrowService;
	

	@RequestMapping(value = root + "/view-records", method = RequestMethod.GET)
	public String view(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		log.info("PATH: " + request.getContextPath());

		HttpSession session = request.getSession();

		String radioValue = request.getParameter("radioValueCategory");

		switch (radioValue) {
		default:
		case "books":
			// List<Book> books = JavaPersistenceDBManager.getAllBooks();
			List<Book> books = bookService.getAllBooks();
			Map<Integer, String> nominatives = new HashMap<Integer, String>();
			Map<Integer, String> names = new HashMap<Integer, String>();
			// log.info(books.toString());

			for(Book b : books) {
				nominatives.put(b.getId(), authorService.getAuthorNominative(b.getAuthorId()));
				names.put(b.getId(), publisherService.getPublisherName(b.getPublisherId()));
			}
			
			model.addAttribute("category", "book");
			model.addAttribute("records", books);
			model.addAttribute("nominatives", nominatives);
			model.addAttribute("names", names);
			
			break;
		case "authors":
			List<Author> authors = authorService.getAllAuthors();
			// log.info(authors.toString());
			model.addAttribute("category", "author");
			model.addAttribute("records", authors);
			break;
		case "publishers":
			List<Publisher> publishers = publisherService.getAllPublishers();
			// log.info(publishers.toString());
			model.addAttribute("category", "publisher");
			model.addAttribute("records", publishers);
			break;
		}

		return root + "/view";
	}
	
	
	@RequestMapping(value = root + "/view-borrows", method = RequestMethod.GET)
	public String viewBorrows(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		log.info("PATH: " + request.getContextPath());

		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");
		
		if(user != null) {
			
			List<Borrow> borrows = borrowService.getUserBorrows(user.getId());
			Map<Integer, String> titles = new HashMap<Integer, String>();
			
			for(Borrow b : borrows) {
				titles.put(b.getId(), bookService.getBookTitle(b.getBookId()));
			}
			
			
			model.addAttribute("records", borrows);
			model.addAttribute("titles", titles);
			
			return root + "/borrow";
		} else {
			
			return root + "/login";
		}
	}

}
