package it.beije.oort.service;

import it.beije.oort.model.Libro;
import it.beije.oort.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private BookRepository bookRepository;

    public Libro load(Long id) {
        System.out.println("Carico il libro");
        Optional<Libro> libro = bookRepository.findById(id);

        return libro.orElse(null);
    }
}
