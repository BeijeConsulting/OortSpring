package it.beije.oort.sala.controller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.sala.beans.Autore;

@Repository
public interface AutoreRepository extends JpaRepository<Autore, Integer>{

}
