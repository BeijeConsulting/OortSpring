package it.beije.oort.madonia.biblioteca.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.oort.madonia.biblioteca.ebeans.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {
	Optional<Utente> findByEmailAndPassword(String email, String Password);
}
