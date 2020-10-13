package it.beije.oort.service.search;

import it.beije.oort.model.Autore;
import it.beije.oort.model.Editore;
import it.beije.oort.model.Libro;
import it.beije.oort.repository.AutoreRepository;
import it.beije.oort.repository.BookRepository;
import it.beije.oort.repository.EditoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookSearchService {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AutoreRepository autoreRepository;
    @Autowired
    private EditoreRepository editoreRepository;

    ////////////////////////////////////////////////////////////
    // METODI DI SUPPORTO AL CONTROLLER
    ////////////////////////////////////////////////////////////
    public List<Libro> search(HttpServletRequest request){
        log.info("Chiamato metodo di ricerca nel service.");

        String column = request.getParameter("column");
        String query = request.getParameter("query");

        log.info("Column: " + column + ". Query: " + query);

        List<Libro> libri = new ArrayList<>();

        switch (column){
            case "autore":
                log.info("Cerco Libro per Autore");
                libri = searchBookByAuthor(query);
                break;
            case "annoPubblicazione":
                log.info("Cerco Libro per Anno di Pubblicazione");
                libri = searchBookByAnno(query);
                break;
            case "id":
                log.info("Cerco Libro per ID");
                libri = searchBookByID(query);
                break;
            case "titolo":
                log.info("Cerco Libro per Titolo");
                libri = searchBookByTitle(query);
                break;
            case "editore":
                log.info("Cerco Libro per Editore");
                libri = searchBookByEditore(query);
        }
        return libri;
    }

    ////////////////////////////////////////////////////////////
    // METODI DI RICERCA
    ////////////////////////////////////////////////////////////
    public List<Libro> searchBookByAuthor(String query){
        Autore autore = autoreRepository.getFirstByNomeContainingOrCognomeContaining(query, query).orElse(null);
        if (autore != null) return bookRepository.getLibrosByIdAutore(autore.getId());
        else return null;
    }

    // todo fare come per l'autore (gestione del null)
    public List<Libro> searchBookByEditore(String query){
        Editore editore = editoreRepository.getFirstByNomeContaining(query).orElse(null);
        if (editore != null) return bookRepository.getLibrosByIdEditore(editore.getId());
        else return null;
    }

    public List<Libro> searchBookByID(Long id){
        log.info("Cerco libro per ID: " + id);
        return bookRepository.getLibrosByIdLike(id);
    }

    public List<Libro> searchBookByID(String idString){
        log.info("Cerco libro per ID-Stringa: " + idString);
        Long id = 0L;
        try{
            id = Long.valueOf(idString);
        } catch (NumberFormatException e){
            log.warn("NumberFormatException");
            e.printStackTrace();
        }
        log.info("ID-Stringa Convertito: " + id);
        return searchBookByID(id);
    }

    public List<Libro> searchBookByTitle(String title){
        return bookRepository.getLibrosByTitoloContaining(title);
    }

    public List<Libro> searchBookByAnno(String anno){
        try{
            Date data = Date.valueOf(anno);
            return bookRepository.getLibrosByAnnoPubblicazione(data);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
