package it.beije.oort.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import it.beije.oort.sb.biblioteca.Libri;


@Repository
public interface LibriRepository extends JpaRepository<Libri, Integer> {
	
	//IM : count u from User u where email = ?

	List<Libri> findByAutore(Integer autore);
	List<Libri> findByEditore(Integer editore);
	List<Libri> findByAutoreAndEditore(Integer autore, Integer editore);

	
	//Optional<Utente> findByEmailAndPassword(String email, String password);
	
}

