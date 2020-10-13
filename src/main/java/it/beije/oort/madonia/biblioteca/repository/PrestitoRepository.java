package it.beije.oort.madonia.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.madonia.biblioteca.ebeans.Prestito;

@Repository
public interface PrestitoRepository extends JpaRepository<Prestito, Integer> {
	List<Prestito> findByIdUtente(Integer idUtente);
}
