package it.beije.oort.service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.repository.PrestitiRepository;
import it.beije.oort.sb.biblioteca.Prestiti;
import it.beije.oort.sb.jpa.JPDBtools;

@Service
public class PrestitiService {

	@Autowired
	private PrestitiRepository prestitiRepository;
	
	public void deleteById(Integer id) {
		prestitiRepository.deleteById(id);
	}
	
	public List<Prestiti> load(){
		return prestitiRepository.findAll();
	}
	
	public List<Prestiti> loadByUtente(int utente){
		return prestitiRepository.findByUtente(utente);
	}
	
	public List<Prestiti> loadByLibro(int libro){
		return prestitiRepository.findByLibro(libro);
	}
	
	public String insert(String dataInizio, String dataFine, Prestiti prestito) {
		String messaggio;
		try {
			prestito.setDataFine(LocalDate.parse(dataFine));
		} catch(DateTimeParseException e) {
		}
		try {
			//la data di inizio non deve dare errore
			prestito.setDataInizio(LocalDate.parse(dataInizio));
			prestitiRepository.saveAndFlush(prestito);
			messaggio= "Prestito Registrato Correttamente";
			return messaggio;
		}catch(Exception e) {
			messaggio= "Impossibile Registrare Prestito";
			return messaggio;
		}
	}
}
