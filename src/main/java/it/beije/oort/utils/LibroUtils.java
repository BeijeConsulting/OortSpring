package it.beije.oort.utils;

import it.beije.oort.model.Libro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe per metodi Utils su oggetti Libro
 */
public class LibroUtils {
    private final static Logger log = LoggerFactory.getLogger(LibroUtils.class);

    /**
     * Copy properties ignoring null or empty fields
     * @param vecchio Libro object which will be updated
     * @param nuovo Libro object to take new fields from
     */
    public static void merge(Libro vecchio, Libro nuovo){
        log.info("Merging ID: " + vecchio.getId() + " and ID: " + nuovo.getId());
        try{
            if (nuovo.getTitolo() != null && !nuovo.getTitolo().equalsIgnoreCase(""))
                vecchio.setTitolo(nuovo.getTitolo());
            if (nuovo.getAnnoPubblicazione() != null)
                vecchio.setAnnoPubblicazione(nuovo.getAnnoPubblicazione());
            if (nuovo.getIdAutore() != null && nuovo.getIdAutore() > 0)
                vecchio.setIdAutore(nuovo.getIdAutore());
            if (nuovo.getIdEditore() != null && nuovo.getIdEditore() > 0)
                vecchio.setIdEditore(nuovo.getIdEditore());
            if (nuovo.getDescrizione() != null && !nuovo.getDescrizione().equalsIgnoreCase(""))
                vecchio.setDescrizione(nuovo.getDescrizione());
        } catch (Exception e){
            e.printStackTrace();
            log.warn("Merge failed.");
        }
        log.info("Merge successful.");
    }
}
