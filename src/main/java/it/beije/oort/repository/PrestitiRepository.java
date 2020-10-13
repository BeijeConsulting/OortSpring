package it.beije.oort.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.sb.biblioteca.Prestiti;

@Repository
public interface PrestitiRepository  extends JpaRepository<Prestiti, Integer>{

	List<Prestiti> findByUtente(Integer utente);
	List<Prestiti> findByLibro(Integer libro);
}
