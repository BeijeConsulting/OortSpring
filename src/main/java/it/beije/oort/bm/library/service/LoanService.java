package it.beije.oort.bm.library.service;

import org.springframework.stereotype.Service;

import it.beije.oort.bm.library.database.old.ConcreteDatabase;
import it.beije.oort.bm.library.database.old.Database;
import it.beije.oort.bm.library.entity.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class LoanService {
	private static Database db = ConcreteDatabase.getDatabase();
	
	public boolean startLoan(int user_id, int book_id) {
		Loan loan = new Loan();
		Book b = new Book();
		b.setId(book_id);
		List<Book> books = db.searchRecord(Book.class, b);
		if(books.size() != 1) {
			throw new IllegalArgumentException();
		} else {
			b = books.get(0);
		}
		User u = new User();
		u.setId(user_id);
		List<User> users = db.searchRecord(User.class, u);
		if(users.size() != 1) {
			throw new IllegalArgumentException();
		}else {
			u = users.get(0);
		}
		loan.setBook(b);
		loan.setUser(u);
		loan.setStart_date(Date.valueOf(LocalDate.now()));
		return db.add(loan);
	}
	
	public boolean endLoan(int loan_id) {
		Loan loan = new Loan();
		loan.setEnd_date(Date.valueOf(LocalDate.now()));
		return db.update(Loan.class, loan_id, loan);
	}
	
	public List<Loan> getLoans(User u){
		List<Loan> ret;
		if(!u.getAdmin()) {
			Loan searchParams = new Loan();
			searchParams.setUser(u);
			ret = db.searchRecord(Loan.class, searchParams);
		} else {
			ret = db.getAll(Loan.class);
		}
		return ret;
	}
}
