package it.beije.oort.bassanelli.library_application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.bassanelli.library_application.entity.Borrow;
import it.beije.oort.bassanelli.library_application.repository.BorrowRepository;

@Service
public class BorrowService {

	@Autowired
	private BorrowRepository borrowRepository;
	
	public List<Borrow> getAllBorrows() {
		return borrowRepository.findAll();
	}
	
	public List<Borrow> getUserBorrows(Integer id){
		return borrowRepository.findByUserId(id);
	}
}
