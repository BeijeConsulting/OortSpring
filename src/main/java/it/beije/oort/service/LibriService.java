package it.beije.oort.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.repository.AutoriRepository;
import it.beije.oort.repository.LibriRepository;
import it.beije.oort.repository.UtentiRepository;
import it.beije.oort.sb.biblioteca.Autori;
import it.beije.oort.sb.biblioteca.Libri;
import it.beije.oort.sb.biblioteca.Utenti;
import it.beije.oort.sb.jpa.JPDBtools;

@Service
public class LibriService {
	

	
	@Autowired
	private LibriRepository libriRepository;
	
	public List<Libri> catalogo(String autore, String editore){
		if("".equals(autore)&&"".equals(editore)) return libriRepository.findAll();
		else if("".equals(autore)) return libriRepository.findByEditore(Integer.parseInt(editore));
		else if("".equals(editore)) return libriRepository.findByAutore(Integer.parseInt(autore));
		else return libriRepository.findByAutoreAndEditore(Integer.parseInt(autore), Integer.parseInt(editore));
	}
	
	public List<Libri> catalogoPostService(String autore, String editore) throws Exception {
		List<Libri> catalogo;		
		if(autore.equals(editore) && autore.equals("0")){ 			
		catalogo = JPDBtools.catalogoLibri();
		} else { 
				try {
					catalogo = JPDBtools.catalogoLibriPersonalizzato(Integer.parseInt(autore), Integer.parseInt(editore));
			} 	catch(Exception e) {
					throw new Exception();
			}
		}
		
		return catalogo;
		
	}

}
