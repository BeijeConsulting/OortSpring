package it.beije.oort.bassanelli.library_application.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.bassanelli.library_application.entity.User;
import it.beije.oort.bassanelli.library_application.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User load(Integer id) {

		Optional<User> user = userRepository.findById(id);

		return user.isPresent() ? user.get() : null;

	}

	public User login(String email, String password) {

		Optional<User> user = userRepository.findByEmailAndPassword(email, password);

		return user.isPresent() ? user.get() : null;

	}

	public void insert(User user) {
		
		if(user == null) {
			throw new IllegalArgumentException("User bean is null");
		}
		
		if (!"".equals(user.getName()) || !"".equals(user.getSurname()) || !"".equals(user.getFiscalCode())
				|| !"".equals(user.getEmail()) || !"".equals(user.getMobile()) || !"".equals(user.getAddress())
				|| !"".equals(user.getPassword())) { 
		
			userRepository.save(user);
		
		} else {
			throw new IllegalArgumentException("User bean data is not valid");
		}
	}
	
	
	public void update(Integer id, User oldUser) {

		if (oldUser == null) {
			throw new IllegalArgumentException("User bean is null");
		}

		if (!"".equals(oldUser.getName()) || !"".equals(oldUser.getSurname()) || !"".equals(oldUser.getFiscalCode())
				|| !"".equals(oldUser.getEmail()) || !"".equals(oldUser.getMobile()) || !"".equals(oldUser.getAddress())
				|| !"".equals(oldUser.getPassword())) {
			
			User user = load(id);
			
			if(user == null) {
				throw new IllegalArgumentException("User bean is not exists");
			}
			
			BeanUtils.copyProperties(oldUser, user, "id");
			
			userRepository.save(user);
			
		} else {
			throw new IllegalArgumentException("User bean data is not valid");
		}

	}

}
