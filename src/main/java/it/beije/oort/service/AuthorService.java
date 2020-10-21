package it.beije.oort.service;

import it.beije.oort.model.Autore;
import it.beije.oort.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AutoreRepository autoreRepository;

    /**
     * Returns an Autore from the Database given an ID
     * @param id the ID of the Autore object to retrieve
     * @return the Autore object
     */
    public Autore load(Long id) {
        System.out.println("Carico il libro");
        Optional<Autore> autore = autoreRepository.findById(id);

        return autore.orElse(null);
    }

    public List<Autore> getAll(){
        return autoreRepository.findAll();
    }

    public List<Autore> getByNameAndSurname(String name, String surname){
        return autoreRepository.getAllByNomeContainingOrCognomeContaining(name, surname);
    }

    public List<Autore> getByName(String name){
        return autoreRepository.getAllByNomeContaining(name);
    }
}
