package it.beije.oort.brugaletta.services;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import it.beije.oort.brugaletta.db.JPDBEntityManagerFactory;
import it.beije.oort.brugaletta.entity.Prestito;

@Service
public class LoanService {
	LoanService loanService = new LoanService();
	
	private boolean isAvalaible(int idUtente, int idLibro) {
		List<Prestito> loans = loanService.exportLoans();
		for (int i = 0; i < loans.size(); i++) {
			if (loans.get(i).getId_libro() == idLibro) {
				return false;
			}
		}
		return true;
	}
	
	public String insertLoan(int idLibro, int idUtente, LocalDate data_inizio, LocalDate data_fine, String note) {
		String message = new String();
		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		if (isAvalaible(idUtente, idLibro)) {
			Prestito loan = new Prestito();
			loan.setId_libro(idLibro);
			loan.setId_utente(idUtente);
			loan.setData_inizio(data_inizio);
			loan.setData_fine(data_fine);
			loan.setNote(note);
			entityManager.persist(loan);
			transaction.commit();
			message = "Nuovo prestito registrato!";
		} else {
			transaction.rollback();
			message = "Libro non disponibile.";
		}
		return message;
	}
	
	public List<Prestito> exportLoans(int idUtente) {
		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
		String jpql = "SELECT p FROM Prestito p WHERE id_utente = " + idUtente;
		Query query = entityManager.createQuery(jpql);
		List<Prestito> loans = query.getResultList();
		entityManager.close();
		return loans;
	}
	
	public List<Prestito> exportLoans() {
		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
		String jpql = "SELECT p FROM Prestito p";
		Query query = entityManager.createQuery(jpql);
		List<Prestito> loans = query.getResultList();
		entityManager.close();
		return loans;
	}
	
	public void updateLoan(String nota, int idPrestito) {
		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "UPDATE Prestito SET note = '" + nota + "' where id = " + idPrestito;
		Query query = entityManager.createQuery(jpql); 
		query.executeUpdate();
		transaction.commit();
		entityManager.close();
	}
	
	public void deleteLoan(int idPrestito) {
		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "DELETE Prestito where id = " + idPrestito;
		Query query = entityManager.createQuery(jpql); 
		query.executeUpdate();
		transaction.commit();
		entityManager.close();
	}
}
