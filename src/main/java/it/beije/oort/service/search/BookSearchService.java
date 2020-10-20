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

    private final Logger log = LoggerFactory.getLogger(this.getClass());

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
                //libri = searchBookByAuthor(query);
                libri = searchBookByMultipleAuthors(query);
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
    // METODI DI RICERCA EFFETTIVA
    ////////////////////////////////////////////////////////////

    /**
     * Data una query, cerca nel nome e nel cognome degli Autori la query e poi ritorna i libri di tali autori.
     */
    public List<Libro> searchBookByMultipleAuthors(String query){
        List<Autore> autori = autoreRepository.getAllByNomeContainingOrCognomeContaining(query, query);
        List<Long> ids = new ArrayList<>();
        for (Autore a : autori){
            log.info("Autore trovato: " + a.toString());
            ids.add(a.getId());
        }
        return bookRepository.findAllByIdAutoreIn(ids);
    }

    /**
     * Data una query, ritorna tutti i libri del primo editore contenente anche solo parte della query.
     * TODO Fare come per gli autori, cioè stampare TUTTI i libri di TUTTI gli editori contententi tale query
     */
    public List<Libro> searchBookByEditore(String query){
        Editore editore = editoreRepository.getFirstByNomeContaining(query).orElse(null);
        if (editore != null) return bookRepository.getLibrosByIdEditore(editore.getId());
        else return null;
    }

    /**
     * Cerca libro per ID esatto
     */
    public List<Libro> searchBookByID(Long id){
        log.info("Cerco libro per ID: " + id);
        return bookRepository.getLibrosByIdLike(id);
    }

    /**
     * Cerca libro per ID esatto in String.
     */
    public List<Libro> searchBookByID(String idString){
        log.info("Cerco libro per ID-Stringa: " + idString);
        long id = 0L;
        try{
            id = Long.parseLong(idString);
        } catch (NumberFormatException e){
            log.warn("NumberFormatException");
            e.printStackTrace();
        }
        log.info("ID-Stringa Convertito: " + id);
        return searchBookByID(id);
    }

    /**
     * Cerca libro per titolo.
     */
    public List<Libro> searchBookByTitle(String title){
        return bookRepository.getLibrosByTitoloContaining(title);
    }

    /**
     * Cerca libro per Anno. Al momento rotto.
     * TODO: Fare un parser Stringa -> Data generico, che accetta date parziali e le converte in date complete così da non rompere Java
     */
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