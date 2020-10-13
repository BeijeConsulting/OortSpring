package it.beije.oort.bm.library.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import it.beije.oort.bm.library.database.old.ConcreteDatabase;
import it.beije.oort.bm.library.database.old.Database;
import it.beije.oort.bm.library.entity.User;

@Service
public class UserService {
	
	private static Database db = ConcreteDatabase.getDatabase();
	
	public User login(String email, String password, Model model) {
		User logged = null;
		User u = new User();
		u.setPassword(password);
		u.setEmail(email);
		List<User> result = db.searchRecord(User.class, u);
		if(result.size() != 1) {
			model.addAttribute("tmpEmail", email);
			model.addAttribute("loginError", "Credenziali errate, riprova.");
		} else {
			logged = result.get(0);
		}
		return logged;
	}
	
	public boolean register(User user) {
		return db.add(user);
	}
	
	public List<User> getAll(){
		return db.getAll(User.class);
	}
}
