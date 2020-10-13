package it.beije.oort.madonia.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.madonia.biblioteca.ebeans.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {

}
