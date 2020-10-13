package it.beije.oort.lauria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.lauria.biblioteca.Editore;

@Repository
public interface EditoreRepository extends JpaRepository<Editore, Integer>{

	
	List<Editore> findAll();
	
	List<Editore> findByIdGreaterThan(Integer id);
}
