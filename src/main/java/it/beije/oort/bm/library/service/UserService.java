package it.beije.oort.bm.library.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import it.beije.oort.bm.library.entity.User;
import it.beije.oort.bm.library.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User login(String email, String password, Model model) {
		User logged = null;
		logged = userRepo.findByEmailAndPassword(email,password);
		if(logged == null) {
			model.addAttribute("tmpEmail", email);
			model.addAttribute("loginError", "Credenziali errate, riprova.");
		}
		return logged;
	}
	
	@Transactional
	public boolean register(User user) {
		boolean ret = false;
		if(user != null) {
			user.setAdmin(false);
			userRepo.saveAndFlush(user);
			ret = true;
		}
		return ret;
	}
	
	public List<User> getAll(){
		return userRepo.findAll();
	}
}
