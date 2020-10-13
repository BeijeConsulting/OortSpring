package it.beije.oort.bm.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.beije.oort.bm.library.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{

}