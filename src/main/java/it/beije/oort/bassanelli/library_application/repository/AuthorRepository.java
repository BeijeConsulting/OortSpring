package it.beije.oort.bassanelli.library_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.oort.bassanelli.library_application.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
