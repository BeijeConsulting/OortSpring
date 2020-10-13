package it.beije.oort.sala.controller.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.sala.controller.beans.Prestito;


@Repository
public interface PrestitoRepository extends JpaRepository<Prestito, Integer>{

	List<Prestito> findByIdUtente(Integer idUtente);
}
