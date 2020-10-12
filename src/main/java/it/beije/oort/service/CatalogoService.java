package it.beije.oort.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.beije.oort.sb.biblioteca.Libri;
import it.beije.oort.sb.jpa.JPDBtools;

@Service
public class CatalogoService {
	
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
