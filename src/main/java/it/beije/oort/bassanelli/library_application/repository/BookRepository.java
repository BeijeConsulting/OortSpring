package it.beije.oort.bassanelli.library_application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.oort.bassanelli.library_application.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

	
}
