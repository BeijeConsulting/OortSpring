package it.beije.oort.girardi.biblioteca;

import java.util.List;
import java.util.Optional;

import it.beije.oort.girardi.biblioteca.fields.Utente;

import org.springframework.stereotype.Repository;

@Repository
public interface MyRepository {
	
	List<Utente> findByNome(String nome);
	
	Optional<Utente> findByEmail(String email);
	
	Optional<Utente> findByEmailAndPassword(String email, String password);
	
}
