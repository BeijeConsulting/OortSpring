package it.beije.oort.kirolosmater.biblioteca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.kirolosmater.biblioteca.model.UtenteBiblioteca;

@Repository
public interface UtenteBibliotecaRepository extends JpaRepository<UtenteBiblioteca, Integer>{
	
	//IM : count u from User u where email = ?
	Optional<UtenteBiblioteca> findByEmail(String email);
	
	List<UtenteBiblioteca> findByNome(String nome);
	
//	Optional<UtenteBiblioteca> findByEmailAndPassword(String email, String password);

}
