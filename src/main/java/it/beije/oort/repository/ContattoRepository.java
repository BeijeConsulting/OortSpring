package it.beije.oort.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.oort.entity.ContattoSpring;



public interface ContattoRepository extends JpaRepository<ContattoSpring, Integer> { 
	Optional<ContattoSpring> findByEmail(String email);

	List<ContattoSpring> findByNome(String nome);

}
