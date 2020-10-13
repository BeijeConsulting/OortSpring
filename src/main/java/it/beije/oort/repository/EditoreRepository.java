package it.beije.oort.repository;

import it.beije.oort.model.Editore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EditoreRepository extends JpaRepository<Editore, Long> {
    Optional<Editore> getFirstByNomeContaining(String nome);
}
