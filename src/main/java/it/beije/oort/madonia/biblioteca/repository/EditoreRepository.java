package it.beije.oort.madonia.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.madonia.biblioteca.ebeans.Editore;

@Repository
public interface EditoreRepository extends JpaRepository<Editore, Integer> {
	
	
	
}
