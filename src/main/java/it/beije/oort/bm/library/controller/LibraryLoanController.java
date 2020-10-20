package it.beije.oort.bm.library.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.oort.bm.library.entity.Loan;
import it.beije.oort.bm.library.service.LoanService;

@RestController
@RequestMapping("/loan")
public class LibraryLoanController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private LoanService loanService;
	
	@GetMapping(value = "/all")
	public List<Loan> getAll(){
		log.debug("/loan/all : get");
		return loanService.getAll();
	}
	
	@GetMapping(value = "/get/{id}")
	public Loan get(@PathVariable int id){
		log.debug("/loan/get/{if} : get : id := " + id);
		return loanService.getLoan(id);
	}
	
	@PostMapping( value = "/insert")
	public Loan insert(@RequestBody Loan loan) {
		log.debug("/loan/insert : post : Object := " + loan);
		loanService.addLoan(loan);
		return loan;
	}
	
	@PutMapping( value = "/update/{id}")
	public Loan update(@RequestBody Loan loan, @PathVariable int id){
		log.debug("/loan/upgrade/{if} : get : id := " + id + " : Object := " + loan);
		loan.setId(id);
		return loanService.updateLoan(id, loan);
	}
	@DeleteMapping( value = "/delete/{id}")
	public boolean delete(@PathVariable int id) {
		log.debug("/loan/delete - post - id: " + id);
		return loanService.deleteLoan(id);
	}
	
}
