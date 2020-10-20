package it.beije.oort.gregori.biblioteca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.gregori.biblioteca.Autore;

@Repository
public interface AutoreRepository extends JpaRepository<Autore, Integer> {
	
	Optional<Autore> findById(Integer id);
	Optional<Autore> find(Autore autore);
	List<Autore> findAll(Autore autore);

}
