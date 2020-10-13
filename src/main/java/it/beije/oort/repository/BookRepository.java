package it.beije.oort.repository;

import it.beije.oort.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Libro, Long> {
    List<Libro> getLibrosByIdAutore(Long id);
    List<Libro> getLibrosByIdEditore(Long id);
    List<Libro> getLibrosByTitoloContaining(String titolo);
    List<Libro> getLibrosByIdLike(Long id);
    List<Libro> getLibrosByAnnoPubblicazione(Date annoPubblicazione);
}
