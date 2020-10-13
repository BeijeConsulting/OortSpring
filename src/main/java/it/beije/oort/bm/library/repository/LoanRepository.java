package it.beije.oort.bm.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.beije.oort.bm.library.entity.Loan;
import it.beije.oort.bm.library.entity.User;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer>{

	List<Loan> findByUser(User u);

}
