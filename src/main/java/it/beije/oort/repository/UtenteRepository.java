package it.beije.oort.repository;


import java.util.List;
import java.util.Optional;

import it.beije.oort.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {

}


