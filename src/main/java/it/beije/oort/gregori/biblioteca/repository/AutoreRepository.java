package it.beije.oort.gregori.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.gregori.biblioteca.Autore;

@Repository
public interface AutoreRepository extends JpaRepository<Autore, Integer> {

}
