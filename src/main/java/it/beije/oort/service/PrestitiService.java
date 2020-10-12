package it.beije.oort.service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.springframework.stereotype.Service;

import it.beije.oort.sb.biblioteca.Prestiti;
import it.beije.oort.sb.jpa.JPDBtools;

@Service
public class PrestitiService {

	
	public String newPrestitoService( String data_inizio, String data_fine, Prestiti prestito) {
		String messaggio;
		try {
			prestito.setData_fine(LocalDate.parse(data_fine));
		} catch(DateTimeParseException e) {
		}
		try {
			//la data di inizio non deve dare errore
			prestito.setData_inizio(LocalDate.parse(data_inizio));
			JPDBtools.insert(prestito, "OortBiblioteca");
			messaggio= "Prestito Registrato Correttamente";
			return messaggio;
		}catch(Exception e) {
			messaggio= "Impossibile Registrare Prestito";
			return messaggio;
		}
	}
}
