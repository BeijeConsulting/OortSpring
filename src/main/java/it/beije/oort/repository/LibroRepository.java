package it.beije.oort.repository;


import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.entity.Libro;


@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {
	
	List<Libro> findByTitoloLike(String titolo); //titolo = "a%"
	
	List<Libro> findByIdAfter(Integer idAfter); //tutti i libri con id > idAfter
	
//	List<Libro> findByTitoloAndAutore(String titolo, String id_autore);
	
}