package it.beije.oort.service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.repository.AutoriRepository;
import it.beije.oort.sb.biblioteca.Autori;


@Service
public class AutoriService {

	@Autowired
	private AutoriRepository autoriRepository;
	
	
	public void deleteById(Integer id) {
		autoriRepository.deleteById(id);
	}
	public List<Autori> loadAutori(){
		return autoriRepository.findAll();
	}
	
	public Autori loadById(Integer id) {
		Optional<Autori> autore = autoriRepository.findById(id);
		return autore.isPresent() ? autore.get() : null;
	}
	
	public String insert(String dataDiNascita, String dataDiMorte, Autori autore) {
		String messaggio;
		try {
			autore.setDataMorte(LocalDate.parse(dataDiMorte));
		} catch(DateTimeParseException e) {
		}
		try {
			//la data di nascita non deve dare errore
			autore.setDataNascita(LocalDate.parse(dataDiNascita));
			autoriRepository.saveAndFlush(autore);
			messaggio= "Autore Registrato Correttamente";
			return messaggio;
		}catch(Exception e) {
			messaggio= "Impossibile Registrare Autore";
			return messaggio;
		}
	}
}
