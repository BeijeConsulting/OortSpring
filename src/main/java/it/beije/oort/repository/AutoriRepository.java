package it.beije.oort.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.sb.biblioteca.Autori;
@Repository
public interface AutoriRepository  extends JpaRepository<Autori, Integer>{
		
		List<Autori> findByNome(String nome);

		
	}