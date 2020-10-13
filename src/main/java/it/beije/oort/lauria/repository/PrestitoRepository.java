package it.beije.oort.lauria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.lauria.biblioteca.Prestito;

@Repository
public interface PrestitoRepository extends JpaRepository<Prestito, Integer>{

	List<Prestito> findAll();
	
	List<Prestito> findByIdGreaterThan(Integer id);
	
//	List<Prestito> findByIdUtente(Integer idUtente);
}
