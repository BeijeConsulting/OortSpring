package it.beije.oort.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.sb.biblioteca.Editori;
@Repository
public interface EditoriRepository  extends JpaRepository<Editori, Integer>{
		


		List<Editori> findByDenominazione(String denominazione);

		
	}