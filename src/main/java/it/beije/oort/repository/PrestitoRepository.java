package it.beije.oort.repository;

import it.beije.oort.model.Prestito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestitoRepository extends JpaRepository<Prestito, Long> {
    public List<Prestito> getAllByCfUtente(String cfUtente);
}
