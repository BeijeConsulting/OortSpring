package it.beije.oort.repository;

import it.beije.oort.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Utente, Long> {
    Utente findByEmailAndPassword(String email, String password);
    Utente findByCodiceFiscaleAndPassword(String cf, String password);
}
