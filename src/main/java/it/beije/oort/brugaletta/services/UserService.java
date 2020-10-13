package it.beije.oort.brugaletta.services;

import java.util.Optional;
import javax.transaction.Transactional;
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
	public void insert(String nome, String cognome, String telefono, String email, String codice_fiscale, String indirizzo, String password) {
		
	}
	
//	public User exportLoggedUser(String email, String password) {
//		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
//		String jpql = "SELECT u FROM User AS u WHERE password = '" + password + "' and email = '" + email + "'";
//		Query query = entityManager.createQuery(jpql);
//		User user = (User)query.getSingleResult();
//		return user;
//	}
	
//	public void insertUser(String nome, String cognome, String telefono, String email, String codice_fiscale, String indirizzo, String password) {
//		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
//		EntityTransaction transaction = entityManager.getTransaction();
//		transaction.begin();
//		User user = new User();
//		user.setNome(nome);
//		user.setCognome(cognome);
//		user.setTelefono(telefono);
//		user.setEmail(email);
//		user.setCodice_fiscale(codice_fiscale);
//		user.setIndirizzo(indirizzo);
//		user.setPassword(password);
//		entityManager.persist(user);
//		transaction.commit();
//		entityManager.close();
//	}
}
