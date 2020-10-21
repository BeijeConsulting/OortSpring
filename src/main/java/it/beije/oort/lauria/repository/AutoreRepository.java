package it.beije.oort.lauria.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.lauria.biblioteca.Autore;

@Repository
public interface AutoreRepository extends JpaRepository<Autore, Integer>{

	List<Autore> findAll();
	
	List<Autore> findByIdGreaterThan(Integer id);
	Optional<Autore> findByNomeAndCognome();
}
