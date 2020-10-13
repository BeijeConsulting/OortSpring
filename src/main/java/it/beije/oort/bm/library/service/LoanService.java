package it.beije.oort.bm.library.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.beije.oort.bm.library.entity.Book;
import it.beije.oort.bm.library.entity.Loan;
import it.beije.oort.bm.library.entity.User;
import it.beije.oort.bm.library.repository.BookRepository;
import it.beije.oort.bm.library.repository.LoanRepository;
import it.beije.oort.bm.library.repository.UserRepository;

@Service
public class LoanService {
	
	@Autowired
	private LoanRepository loanRepo;
	@Autowired
	private BookRepository bookRepo;
	@Autowired
	private UserRepository userRepo;

	@Transactional
	public boolean startLoan(int user_id, int book_id) {
		boolean ret = false;
		Loan loan = new Loan();
		Optional<Book> book_data  = bookRepo.findById(book_id);
		Optional<User> user_data  = userRepo.findById(user_id);
		if(book_data.isPresent() && user_data.isPresent()) {
			loan.setBook(book_data.get());
			loan.setUser(user_data.get());
			loan.setStartDate(Date.valueOf(LocalDate.now()));
			loanRepo.save(loan);
			ret = true;
		}
		return ret;
	}
	
	@Transactional
	public boolean endLoan(int loan_id) {
		boolean ret = false;
		Optional<Loan> data = loanRepo.findById(loan_id);
		Loan loan = data.isPresent()? data.get() : null;
		if(loan == null) {
			throw new IllegalArgumentException("Selected loan does not exist on database.");
		}
		if(loan.getEndDate() == null) {
			loan.setEndDate(Date.valueOf(LocalDate.now()));
			loanRepo.save(loan);
			ret = true;
		}
		return ret;
	}
	
	public List<Loan> getLoans(User u){
		List<Loan> ret;
		if(!u.getAdmin()) {
			ret = loanRepo.findByUser(u);
		} else {
			ret = loanRepo.findAll();
		}
		return ret;
	}
}
