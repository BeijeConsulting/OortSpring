package it.beije.oort.madonia.biblioteca.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.madonia.biblioteca.ebeans.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {
	Optional<Utente> findByEmailAndPassword(String email, String password);
}
