package it.beije.oort.madonia.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.madonia.biblioteca.ebeans.Autore;

@Repository
public interface AutoreRepository extends JpaRepository<Autore, Integer> {

}
