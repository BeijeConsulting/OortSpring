package it.beije.oort.database;

import it.beije.oort.model.*;

import java.util.List;

// todo update
public class DatabaseController {
    private static final GenericDatabaseManager dbm = new GenericDatabaseManager();

    // Generic
    public static void insert(IBibliotecaModel oggetto){dbm.insert(oggetto);}

    // Libri
    public static Libro getLibro(Long id){
        return (Libro) dbm.get(Libro.class, id);
    }
    public static void insertLibro(Libro libro){
        dbm.insert(libro);
    }
    public static void deleteLibro(Long id){
        dbm.delete(Libro.class, id);
    }
    public static void deleteLibro(Libro libro){
        deleteLibro(libro.getId());
    }
    public static List<Libro> getAllLibri(){return (List<Libro>) dbm.getAll(Libro.class);}

    // Autore
    public static Autore getAutore(Long id){
        return (Autore) dbm.get(Autore.class, id);
    }
    public static void insertAutore(Autore autore){
        dbm.insert(autore);
    }
    public static void deleteAutore(Long id){
        dbm.delete(Autore.class, id);
    }
    public static void deleteAutore(Autore autore){
        deleteAutore(autore.getId());
    }
    public static List<Autore> getAllAutori(){return (List<Autore>) dbm.getAll(Autore.class);}

    // Editore
    public static Editore getEditore(Long id){
        return (Editore) dbm.get(Editore.class, id);
    }
    public static void insertEditore(Editore editore){
        dbm.insert(editore);
    }
    public static void deleteEditore(Long id){
        dbm.delete(Editore.class, id);
    }
    public static void deleteEditore(Editore editore){
        deleteEditore(editore.getId());
    }
    public static List<Editore> getAllEditori(){return (List<Editore>) dbm.getAll(Editore.class);}

    // Utente
    public static Utente getUtente(Long id){
        return (Utente) dbm.get(Utente.class, id);
    }
    public static Utente getUtente(String cf){
        return dbm.getUtente(cf);
    }
    public static Utente getUtenteFromMail(String mail){return dbm.getUtenteFromMail(mail);}
    public static void insertUtente(Utente utente){
        dbm.insert(utente);
    }
    public static void deleteUtente(Long id){
        dbm.delete(Utente.class, id);
    }
    public static void deleteUtente(Utente utente){
        deleteUtente(utente.getId());
    }
    public static List<Utente> getAllUtenti(){return (List<Utente>) dbm.getAll(Utente.class);}

    // Prestito
    public static Prestito getPrestito(Long id){
        return (Prestito) dbm.get(Prestito.class, id);
    }
    public static void insertPrestito(Prestito prestito){
        dbm.insert(prestito);
    }
    public static void deletePrestito(Long id){
        dbm.delete(Prestito.class, id);
    }
    public static void deletePrestito(Prestito prestito){
        deletePrestito(prestito.getId());
    }public static List<Prestito> getAllPrestiti(){return (List<Prestito>) dbm.getAll(Prestito.class);}

}
