package it.beije.oort.bassanelli.library_application.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.bassanelli.library_application.database_manager.JavaPersistenceDBManager;
import it.beije.oort.bassanelli.library_application.entity.Author;
import it.beije.oort.bassanelli.library_application.entity.Book;
import it.beije.oort.bassanelli.library_application.entity.Publisher;
import it.beije.oort.bassanelli.library_application.entity.User;
import it.beije.oort.bassanelli.library_application.service.AuthorService;
import it.beije.oort.bassanelli.library_application.service.BookService;
import it.beije.oort.bassanelli.library_application.service.PublisherService;

@Controller
public class ViewController {

	private static final String root = "/library";
	
	@Autowired
	private BookService bookService;
	private AuthorService authorService;
	private PublisherService publisherService;
	

	@RequestMapping(value = root + "/view-records", method = RequestMethod.GET)
	public String view(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale)
			throws UnsupportedEncodingException {
		System.out.println("path: " + request.getContextPath());

		HttpSession session = request.getSession();

		String radioValue = request.getParameter("radioValue");

		switch (radioValue) {
		case "books":
			// List<Book> books = JavaPersistenceDBManager.getAllBooks();
			List<Book> books = bookService.getAllBooks();
			model.addAttribute("records", books);
			break;
		case "authors":
			List<Author> authors = authorService.getAllAuthors();
			model.addAttribute("records", authors);
			break;
		case "publishers":
			List<Publisher> publishers = publisherService.getAllPublishers();
			model.addAttribute("records", publishers);
			break;
		}

		return root + "/view";
	}

}
