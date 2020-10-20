package it.beije.oort.service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.repository.AutoriRepository;
import it.beije.oort.sb.biblioteca.Autori;
import it.beije.oort.sb.biblioteca.Utenti;


@Service
public class AutoriService {

	@Autowired
	private AutoriRepository autoriRepository;
	
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
	
	public boolean insert(Autori autore) {
		try{
			autoriRepository.saveAndFlush(autore);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
//	@Transactional
	public Autori update(Integer id, Autori datiAutore) {
		
		if (datiAutore == null) {
			throw new IllegalArgumentException("bean autore null");
		}
		
		if (!"".equals(datiAutore.getCognome()) || !"".equals(datiAutore.getNome())) {
			
			Autori autore = loadById(id);
			
			if (autore == null) {
				throw new IllegalArgumentException("non è presente un autore con id " + id);
			}
			
			BeanUtils.copyProperties(datiAutore, autore, "id");
			
			autoriRepository.save(autore);
			
			return autore;
			
		} else throw new IllegalArgumentException("dati autore non presenti");
		
	}
	public String deleteById(Integer id) {
		Autori autore = loadById(id);
		if(autore!= null) {
			autoriRepository.delete(autore);
			return "autore cancellato correttamente";
		} else throw new IllegalArgumentException("NESSUN AUTORE CON ID " + id);
				
	}
}
