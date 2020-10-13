package it.beije.oort.brugaletta.services;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.beije.oort.repository.LoanRepository;
import it.beije.oort.brugaletta.entity.*;

@Service
public class LoanService {
	@Autowired
	LoanRepository loanRepository;
	
	public List<Prestito> showUserLoans(int idUtente) {
		List<Prestito> loans = loanRepository.findByUtente(idUtente);
		return loans;
	}
	
	@Transactional
	public void insertLoan(Prestito loan) {
		if (loan == null) {
			throw new IllegalArgumentException("prestito non esistente");
		}
		loanRepository.save(loan);
	}
}
