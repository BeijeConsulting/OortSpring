package it.beije.oort.repository;

import it.beije.oort.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Libro, Long> {
}
