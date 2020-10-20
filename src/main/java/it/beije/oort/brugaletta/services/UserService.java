package it.beije.oort.brugaletta.services;

import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.beije.oort.brugaletta.entity.User;
import it.beije.oort.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
		
	public User login(String email, String password) {
		Optional<User> user = userRepository.findByEmailAndPassword(email, password);
		return user.isPresent() ? user.get() : null;
	}
	
	@Transactional
	public void insert(User utente) {
		if (utente == null) {
			throw new IllegalArgumentException("utente non esistente");
		}
		userRepository.save(utente);
	}
	
	@Transactional
	public User update(int id, User userData) {
		if (userData == null) {
			throw new IllegalArgumentException("userData is null");
		}
		Optional<User> user = userRepository.findById(id);
		if (user == null) {
			throw new IllegalArgumentException("A user with id " + id + " doesn't exist");
		}
		BeanUtils.copyProperties(userData, user.get(), "id");
		return userRepository.save(user.get());
	}
}
