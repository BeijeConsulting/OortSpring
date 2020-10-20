package it.beije.oort.kirolosmater.biblioteca;

import static it.beije.oort.kirolosmater.biblioteca.LibraryManager.libraryPersistenceUnit;
import static it.beije.oort.kirolosmater.biblioteca.MetodiUtente.readRecordByStringFromInput;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.kirolosmater.biblioteca.model.JPAEntityManagerSingleton;
import it.beije.oort.kirolosmater.biblioteca.model.UtenteBiblioteca;
import it.beije.oort.kirolosmater.biblioteca.repository.UtenteBibliotecaRepository;

@Service
public class MetodiUtente {
	
//	@Autowired
//	private UtenteBibliotecaRepository utenteBibliotecaRepository;
	
	static EntityManager entityManager = JPAEntityManagerSingleton.getEntityManager(libraryPersistenceUnit);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static UtenteBiblioteca readRecordFromDb(int id) { 		
		UtenteBiblioteca utente = entityManager.find(UtenteBiblioteca.class, id);
		return utente;
	}
	
	public static void visualizzaUtenteById () {
		String showRecordById = "Per visualizzare un autore inserisci il suo id: ";
		System.out.println(showRecordById);
		Scanner inputFromUser = new Scanner(System.in);
		String lineFromInput = inputFromUser.next();
		int id = Integer.parseInt(lineFromInput);
//		System.out.println("hai inserito questo id: " + id);
//		System.out.println("questo è il record: ");
		UtenteBiblioteca utente = readRecordFromDb(id);
//		System.out.println("id : " + utente.getId());			
//		System.out.println("cognome : " + utente.getCognome());
//		System.out.println("nome : " + utente.getNome());
//		System.out.println("codice_fiscale : " + utente.getCodice_fiscale());
//		System.out.println("email : " + utente.getEmail());
//		System.out.println("telefono : " + utente.getTelefono());
//		System.out.println("indirizzo : " + utente.getIndirizzo());
	}
	
	public static List<UtenteBiblioteca> readRecordByStringFromInput () {
		Scanner inputFromUser = new Scanner(System.in);
		System.out.println("Inserisci il parametro da analizzare: ");
		String parameter = inputFromUser.nextLine();
		String stringRequest = "Inserisci la stringa iniziale: ";
		System.out.println(stringRequest);
		String lineFromInput = inputFromUser.nextLine();
		String jpql = "SELECT c FROM Utente as c WHERE " + parameter + " LIKE '" + lineFromInput + "%'";
		Query query = (Query) entityManager.createQuery(jpql);
		List<UtenteBiblioteca> utenti = query.getResultList();
//		for (UtenteBiblioteca utente : utenti) {
//			System.out.println("id : " + utente.getId());			
//			System.out.println("cognome : " + utente.getCognome());
//			System.out.println("nome : " + utente.getNome());
//			System.out.println("codice_fiscale : " + utente.getCodice_fiscale());
//			System.out.println("email : " + utente.getEmail());
//			System.out.println("telefono : " + utente.getTelefono());
//			System.out.println("indirizzo : " + utente.getIndirizzo());
//		}
		return utenti;
	}
	
	public static List<UtenteBiblioteca> readRecordByStringFromInput (String parametro, String stringaIniziale) {
		String parameter = parametro;
		String lineFromInput = stringaIniziale;
		String jpql = "SELECT c FROM Utente as c WHERE " + parameter + " LIKE '" + lineFromInput + "%'";
		Query query = (Query) entityManager.createQuery(jpql);
		List<UtenteBiblioteca> utenti = query.getResultList();
//		for (UtenteBiblioteca utente : utenti) {
//			System.out.println("id : " + utente.getId());			
//			System.out.println("cognome : " + utente.getCognome());
//			System.out.println("nome : " + utente.getNome());
//			System.out.println("codice_fiscale : " + utente.getCodice_fiscale());
//			System.out.println("email : " + utente.getEmail());
//			System.out.println("telefono : " + utente.getTelefono());
//			System.out.println("indirizzo : " + utente.getIndirizzo());
//		}
		return utenti;
	}
	
	public static UtenteBiblioteca checkEmail (String email) {
		UtenteBiblioteca utente = new UtenteBiblioteca();
		List<UtenteBiblioteca> utenti = readRecordByStringFromInput("email", email);
		if(utenti.size() == 0) {
			utente = getUtenteSconosciuto();
		} else {
//			System.out.println(utenti);
			utente = utenti.get(0);
		}
		
		
		return utente;
	}
	
	public static boolean checkPassword (UtenteBiblioteca utente, String password) {
		boolean passwordCorretta = false;
		passwordCorretta = password.equals(utente.getPassword());
		return passwordCorretta;
	}
	
	public static UtenteBiblioteca getUtenteSconosciuto () {
		UtenteBiblioteca sconosciuto = new UtenteBiblioteca();
		sconosciuto.setAdmin(false);
		sconosciuto.setCodiceFiscale("sconosciuto");
		sconosciuto.setCognome("sconosciuto");
		sconosciuto.setEmail("utente.sconosciuto@sconosciuto.sconosciuto");
		sconosciuto.setIndirizzo("sconosciuto");
		sconosciuto.setNome("utente");
		sconosciuto.setTelefono("sconosciuto");
		sconosciuto.setPassword("sconosciuto");
		return sconosciuto;
	}
}
