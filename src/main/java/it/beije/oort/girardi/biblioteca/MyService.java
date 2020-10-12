package it.beije.oort.girardi.biblioteca;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.girardi.biblioteca.fields.Utente;
import it.beije.oort.girardi.jpa.JPAfactoryBiblio;

@Service
public class MyService {

	//apro EntityManagerFactory
	private static final EntityManager entityManager = JPAfactoryBiblio.openEntityFactory();
	
	@Autowired 
	private MyService myService;
	
	public List<Utente> selectUtente (Utente u) {
		//query JPQL
		String jpql = "SELECT a FROM Utente as a WHERE email = '" + u.getEmail() + "' and "
						+ "password = '" + u.getPassword() + "'";
			System.out.println(jpql);
		Query query = entityManager.createQuery(jpql);
		List<Utente> listUtente = query.getResultList();
		return listUtente;
	}

}
