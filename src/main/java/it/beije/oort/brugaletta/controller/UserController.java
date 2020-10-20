package it.beije.oort.brugaletta.controller;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.oort.brugaletta.entity.Libro;
import it.beije.oort.brugaletta.entity.Prestito;
import it.beije.oort.brugaletta.entity.User;
import it.beije.oort.brugaletta.services.BookService;
import it.beije.oort.brugaletta.services.LoanService;
import it.beije.oort.brugaletta.services.UserService;
import it.beije.oort.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	private LoanService loanService;
	@Autowired
	private BookService bookService;
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	
	
	//restituisce gli utenti
	@GetMapping("/users")
	public List<User> getUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}
	
	//restituisce un utente in base all'id
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable int id, Model model) {
		Optional<User> user = userRepository.findById(id);
		return user.get();
	}
	
	//inserisce un nuovo utente
	@PostMapping("/user")
	public User insertUser(@RequestBody User user, HttpServletRequest request, Model model) {
		userService.insert(user);
		return user;
	}
	
	//modifica utente in base all'id
	@PutMapping("/user/{id}")
	public User updateUser(@RequestBody User user, @PathVariable int id, HttpServletRequest request, Model model) {
		if (user.getId() != 0 && user.getId() != id) {
			throw new IllegalArgumentException("User ID not valid");
		}
		return userService.update(id, user);
	}
	
	@DeleteMapping("/user/{id}")
	public String utente(@PathVariable Integer id) {
		Optional<User> user = userRepository.findById(id);
		if (user != null) {
			userRepository.delete(user.get());
			return "cancellato? true";
		} else {
			throw new IllegalArgumentException("Nessun Utente con id  " + id);
		}
	}
	
	@GetMapping("/prestiti")
	public String showLoans(HttpServletRequest request, Model model) {
		User sessionUser = (User)request.getSession().getAttribute("loggedUser");
		log.debug(sessionUser.toString());
		List<Prestito> loans = loanService.showUserLoans(sessionUser.getId());
		model.addAttribute("prestiti", loans);
		return "prestiti_utente";
	}
	
	@GetMapping("/nuovoPrestito")
	public String insertLoan(Model model) {
		List<Libro> books = bookService.showBooks();
		log.debug(books.toString());
		model.addAttribute("libri",books);
		return "nuovo_prestito";
	}
}
