package it.beije.oort.sala.controller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.sala.beans.Editore;

@Repository
public interface EditoreRepository extends JpaRepository<Editore, Integer>{

}
