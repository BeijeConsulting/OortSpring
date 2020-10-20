package it.beije.oort.service;

import it.beije.oort.model.Libro;
import it.beije.oort.repository.BookRepository;
import it.beije.oort.utils.LibroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for anything related to the Libro (Book) Bean
 */
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    /**
     * Returns a Libro from the Database given an ID
     * @param id the ID of the Libro object to retrieve
     * @return the Libro object
     */
    public Libro load(Long id) {
        System.out.println("Carico il libro");
        Optional<Libro> libro = bookRepository.findById(id);

        return libro.orElse(null);
    }

    /**
     * Update Libro in Database
     * @param nuovo the new Libro object
     * @param idVecchio the id of the Libro object to overwrite (will only change modified fields).
     *                  If a field in 'nuovo' object is empty, it will not modify it in the db
     */
    public Libro update(Libro nuovo, Long idVecchio){
        Libro vecchio = load(idVecchio);
        LibroUtils.merge(vecchio, nuovo);
        return bookRepository.save(vecchio);
    }

    /**
     * Save (insert) a Libro object into the database
     * @param libro the Libro to save
     * @return the saved Libro object (with the id from the database)
     */
    public Libro save(Libro libro){
        if (libro == null || libro.isEmpty()) return null;
        try{
            return bookRepository.saveAndFlush(libro);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Deletes a Libro from the Database
     * @param id ID of the Libro to delete
     * @return true if successfully deleted
     */
    public boolean delete(Long id){
        try{
            bookRepository.deleteById(id);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<Libro> getAll(){
        return bookRepository.findAll();
    }
}
