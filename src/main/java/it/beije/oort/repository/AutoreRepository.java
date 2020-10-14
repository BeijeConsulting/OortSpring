package it.beije.oort.repository;

import it.beije.oort.model.Autore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutoreRepository extends JpaRepository<Autore, Long> {
    Optional<Autore> getAutoreByNomeContainingOrCognomeContaining(String nome, String cognome);
    Optional<Autore> getFirstByNomeContainingOrCognomeContaining(String nome, String cognome);

    List<Autore> getAllByNomeContainingOrCognomeContaining(String nome, String cognome);
}
