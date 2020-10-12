package it.beije.oort.bassanelli.library_application.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.bassanelli.library_application.database_manager.JavaPersistenceDBManager;
import it.beije.oort.bassanelli.library_application.entity.Book;
import it.beije.oort.bassanelli.library_application.entity.User;

@Controller
public class ViewController {

	private static final String root = "/library";

	@RequestMapping(value = root + "/view-records", method = RequestMethod.GET)
	public String view(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale)
			throws UnsupportedEncodingException {
		System.out.println("path: " + request.getContextPath());

		HttpSession session = request.getSession();

		String radioValue = request.getParameter("radioValue");

		switch (radioValue) {
		case "books":
			List<Book> books = JavaPersistenceDBManager.getAllBooks();
			System.out.println(books.get(0).toString());
			model.addAttribute("records", JavaPersistenceDBManager.getAllBooks());
			break;
		case "authors":
			model.addAttribute("records", JavaPersistenceDBManager.getAllBooks());
			break;
		case "publishers":
			model.addAttribute("records", JavaPersistenceDBManager.getAllBooks());
			break;
		}

		return root + "/view";
	}

}
