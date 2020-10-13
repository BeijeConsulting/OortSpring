package it.beije.oort.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.beije.oort.brugaletta.entity.Prestito;

@Repository
public interface LoanRepository extends JpaRepository<Prestito, Integer> {
	List<Prestito> findByUtente(int idUtente);
	
}