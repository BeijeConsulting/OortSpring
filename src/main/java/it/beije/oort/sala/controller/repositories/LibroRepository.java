package it.beije.oort.sala.controller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.sala.controller.beans.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer>{

}
