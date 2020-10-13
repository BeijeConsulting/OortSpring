package it.beije.oort.madonia.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import it.beije.oort.madonia.biblioteca.ebeans.Autore;
import it.beije.oort.madonia.biblioteca.ebeans.Ebeans;
import it.beije.oort.madonia.biblioteca.ebeans.Editore;
import it.beije.oort.madonia.biblioteca.ebeans.Libro;
import it.beije.oort.madonia.biblioteca.ebeans.Prestito;
import it.beije.oort.madonia.biblioteca.ebeans.Utente;

public class DatabaseManagerBiblioteca {
	private DatabaseManagerBiblioteca () {}
	
	public static final String OORT_BIBLIOTECA = "OortBiblioteca";
	
	public static Utente login(String email, String password) {
		EntityManager eManager = null;
		Query query = null;
		Utente utente = null;
		String jpql = "SELECT u FROM Utente as u WHERE email = :email AND password = :password";
		try {
			eManager = JpaEntityManagerFactory.createEntityManager(OORT_BIBLIOTECA);
			query = eManager.createQuery(jpql);
			query.setParameter("email", email);
			query.setParameter("password", password);
			utente = (Utente) query.getSingleResult();
		} catch(NoResultException e) {
			utente = null;
		} finally {
			eManager.close();
		}
		
		return utente;
	}
	
	public static void inserisci(Autore autore) {
		if (autore == null) {
			throw new IllegalArgumentException("L'oggetto è vuoto");
		}
		inserisci((Ebeans) autore);
	}
	
	public static void inserisci(Editore editore) {
		if (editore == null) {
			throw new IllegalArgumentException("L'oggetto è vuoto");
		}
		inserisci((Ebeans) editore);
	}
	
	public static void inserisci(Libro libro) {
		if (libro == null) {
			throw new IllegalArgumentException("L'oggetto è vuoto");
		}
		inserisci((Ebeans) libro);
	}
	
	public static void inserisci(Utente utente) {
		if (utente == null) {
			throw new IllegalArgumentException("L'oggetto è vuoto");
		}
		inserisci((Ebeans) utente);
	}
	
	private static void inserisci(Ebeans objEntity) {
		EntityManager eManager = JpaEntityManagerFactory.createEntityManager(OORT_BIBLIOTECA);
		try {
			eManager.getTransaction().begin();
			eManager.persist(objEntity);
			eManager.getTransaction().commit();
		} finally {
			eManager.close();
		}
	}
	
	public static void modifica(Autore autore) {
		EntityManager eManager = JpaEntityManagerFactory.createEntityManager(OORT_BIBLIOTECA);
		try {
			Autore autoreModifica = eManager.find(Autore.class, autore.getId());
			autoreModifica.setNome(autore.getNome());
			autoreModifica.setCognome(autore.getCognome());
			autoreModifica.setDataNascita(autore.getDataNascita());
			autoreModifica.setDataMorte(autore.getDataMorte());
			autoreModifica.setBiografia(autore.getBiografia());
			
			eManager.getTransaction().begin();
			eManager.persist(autoreModifica);
			eManager.getTransaction().commit();
		} finally {
			eManager.close();
		}
	}
	
	public static void modifica(Editore editore) {
		EntityManager eManager = JpaEntityManagerFactory.createEntityManager(OORT_BIBLIOTECA);
		try {
			Editore editoreModifica = eManager.find(Editore.class, editore.getId());
			editoreModifica.setDenominazione(editore.getDenominazione());
			editoreModifica.setDescrizione(editore.getDescrizione());
			
			eManager.getTransaction().begin();
			eManager.persist(editoreModifica);
			eManager.getTransaction().commit();
		} finally {
			eManager.close();
		}
	}
	
	public static void modifica(Libro libro) {
		EntityManager eManager = JpaEntityManagerFactory.createEntityManager(OORT_BIBLIOTECA);
		try {
			Libro libroModifica = eManager.find(Libro.class, libro.getId());
			libroModifica.setTitolo(libro.getTitolo());
			libroModifica.setDescrizione(libro.getDescrizione());
			libroModifica.setIdAutore(libro.getIdAutore());
			libroModifica.setIdEditore(libro.getIdEditore());
			libroModifica.setAnno(libro.getAnno());
			
			eManager.getTransaction().begin();
			eManager.persist(libroModifica);
			eManager.getTransaction().commit();
		} finally {
			eManager.close();
		}
	}
	
	public static void cancellaAutore(Integer id) {
		EntityManager eManager = JpaEntityManagerFactory.createEntityManager(OORT_BIBLIOTECA);
		try {
			Autore autore = eManager.find(Autore.class, id);
			
			eManager.getTransaction().begin();
			eManager.remove(autore);
			eManager.getTransaction().commit();
		} finally {
			eManager.close();
		}
	}
	
	public static void cancellaEditore(Integer id) {
		EntityManager eManager = JpaEntityManagerFactory.createEntityManager(OORT_BIBLIOTECA);
		try {
			Editore editore = eManager.find(Editore.class, id);
			
			eManager.getTransaction().begin();
			eManager.remove(editore);
			eManager.getTransaction().commit();
		} finally {
			eManager.close();
		}
	}
	
	public static void cancellaLibro(Integer id) {
		EntityManager eManager = JpaEntityManagerFactory.createEntityManager(OORT_BIBLIOTECA);
		try {
			Libro libro = eManager.find(Libro.class, id);
			
			eManager.getTransaction().begin();
			eManager.remove(libro);
			eManager.getTransaction().commit();
		} finally {
			eManager.close();
		}
	}
	
	public static Autore trovaAutore(Integer id) {
		EntityManager eManager = null;
		Autore autore = null;
		try {
			eManager = JpaEntityManagerFactory.createEntityManager(OORT_BIBLIOTECA);
			autore = eManager.find(Autore.class, id);
		} catch(NoResultException e) {
			autore = null;
		} finally {
			eManager.close();
		}
		
		return autore;
	}
	
	public static Editore trovaEditore(Integer id) {
		EntityManager eManager = null;
		Editore editore = null;
		try {
			eManager = JpaEntityManagerFactory.createEntityManager(OORT_BIBLIOTECA);
			editore = eManager.find(Editore.class, id);
		} catch(NoResultException e) {
			editore = null;
		} finally {
			eManager.close();
		}
		
		return editore;
	}
	
	public static Libro trovaLibro(Integer id) {
		EntityManager eManager = null;
		Libro libro = null;
		try {
			eManager = JpaEntityManagerFactory.createEntityManager(OORT_BIBLIOTECA);
			libro = eManager.find(Libro.class, id);
		} catch(NoResultException e) {
			libro = null;
		} finally {
			eManager.close();
		}
		
		return libro;
	}
	
	public static List<Prestito> trovaPrestiti(Utente utente) {
		EntityManager eManager = null;
		Query query = null;
		List<Prestito> lista = null;
		String jpql = "SELECT p FROM Prestito as p WHERE utente = :idUtente";
		try {
			eManager = JpaEntityManagerFactory.createEntityManager(OORT_BIBLIOTECA);
			query = eManager.createQuery(jpql);
			query.setParameter("idUtente", utente.getId());
			lista = query.getResultList();
		} catch(NoResultException e) {
			lista = null;
		} finally {
			eManager.close();
		}
		
		return lista;
	}
}
