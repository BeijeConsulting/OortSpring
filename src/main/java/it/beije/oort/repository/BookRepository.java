package it.beije.oort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.beije.oort.brugaletta.entity.Libro;


@Repository
public interface BookRepository extends JpaRepository<Libro, Integer> {
	
}