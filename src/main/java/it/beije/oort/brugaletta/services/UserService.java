package it.beije.oort.brugaletta.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import it.beije.oort.brugaletta.db.JPDBEntityManagerFactory;
import it.beije.oort.brugaletta.entity.User;

@Service
public class UserService {
	public boolean checkLogin(String email, String password) {
		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
		String jpql = "SELECT u FROM User AS u WHERE password = '" + password + "' and email = '" + email + "'";
		Query query = entityManager.createQuery(jpql);
		try {
			User user = (User)query.getSingleResult();
			return true;
		} catch (javax.persistence.NoResultException e) {
			return false;
		}
	}
	
	public User exportLoggedUser(String email, String password) {
		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
		String jpql = "SELECT u FROM User AS u WHERE password = '" + password + "' and email = '" + email + "'";
		Query query = entityManager.createQuery(jpql);
		User user = (User)query.getSingleResult();
		return user;
	}
	
	public void insertUser(String nome, String cognome, String telefono, String email, String codice_fiscale, String indirizzo, String password) {
		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		User user = new User();
		user.setNome(nome);
		user.setCognome(cognome);
		user.setTelefono(telefono);
		user.setEmail(email);
		user.setCodice_fiscale(codice_fiscale);
		user.setIndirizzo(indirizzo);
		user.setPassword(password);
		entityManager.persist(user);
		transaction.commit();
		entityManager.close();
	}
}
