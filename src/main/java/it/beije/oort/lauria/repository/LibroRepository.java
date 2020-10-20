package it.beije.oort.lauria.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.lauria.biblioteca.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer>{
	
	List<Libro> findAll();
	
	List<Libro> findByIdGreaterThan(Integer id);
	
	Optional<Libro> findById(Integer id);
}
