package it.beije.oort.bm.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.beije.oort.bm.library.entity.User;
import it.beije.oort.bm.library.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
//	public User login(String email, String password, Model model) {
//		User logged = null;
//		logged = userRepo.findByEmailAndPassword(email,password);
//		if(logged == null) {
//			model.addAttribute("tmpEmail", email);
//			model.addAttribute("loginError", "Credenziali errate, riprova.");
//		}
//		return logged;
//	}
	
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

	public User getUser(int id) {
		Optional<User> optUser = userRepo.findById(id);
		return optUser.isPresent() ? optUser.get() : null;
	}

	public User addUser(User user) {
		return userRepo.save(user);
		
	}

	public User updateUser(int id, User user) {
		Optional<User> optSaved = userRepo.findById(id);
		User saved = null;
		if(optSaved.isPresent()) {
			saved = optSaved.get();
			BeanUtils.copyProperties(user, saved);
			userRepo.save(saved);
		}
		return saved;
	}

	public boolean deleteUser(int id) {
		boolean ret = false;
		if(userRepo.findById(id).isPresent()) {
			userRepo.deleteById(id);
			ret = true;
		}
		return ret;
	}

	public User login(String email, String password) {
		User logged = null;
		logged = userRepo.findByEmailAndPassword(email,password);
		return logged;
		
	}
}
