package it.beije.oort.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.entity.Utente;


@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {
	
	String getNominativo(Utente utente);
	
	Utente load(Integer id);

	List<Utente> findByNome(String nome);
	
	Optional<Utente> findByEmail(String email);
	//Optional<Utente> findByEmailAndPassword(String email, String password);
	
	void insert(Utente utente);
	
	void update(Integer id, Utente datiUtente);
	
}


