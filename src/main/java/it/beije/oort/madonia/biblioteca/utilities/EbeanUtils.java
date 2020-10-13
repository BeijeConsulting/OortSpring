package it.beije.oort.madonia.biblioteca.utilities;

import it.beije.oort.madonia.biblioteca.ebeans.Autore;
import it.beije.oort.madonia.biblioteca.ebeans.Editore;
import it.beije.oort.madonia.biblioteca.ebeans.Libro;
import it.beije.oort.madonia.biblioteca.ebeans.Prestito;
import it.beije.oort.madonia.biblioteca.ebeans.Utente;

public class EbeanUtils {
	
	public static boolean autoreIsEmpty(Autore autore) {
		return GeneralUtils.stringIsNullOrEmpty(autore.getNome())
				&& GeneralUtils.stringIsNullOrEmpty(autore.getCognome())
				&& GeneralUtils.stringIsNullOrEmpty(autore.getBiografia())
				&& autore.getDataNascita() == null
				&& autore.getDataMorte() == null;
	}
	
	public static boolean editoreIsEmpty(Editore editore) {
		return GeneralUtils.stringIsNullOrEmpty(editore.getDenominazione())
				&& GeneralUtils.stringIsNullOrEmpty(editore.getDescrizione());
	}
	
	public static boolean libroIsEmpty(Libro libro) {
		return GeneralUtils.stringIsNullOrEmpty(libro.getTitolo())
				&& GeneralUtils.stringIsNullOrEmpty(libro.getDescrizione())
				&& libro.getIdAutore() == null
				&& libro.getIdEditore() == null
				&& libro.getAnno() == null;
	}
	
	public static boolean prestitoIsEmpty(Prestito prestito) {
		return prestito.getIdLibro() == null
				&& prestito.getIdUtente() == null
				&& prestito.getDataInizio() == null
				&& prestito.getDataFine() == null
				&& GeneralUtils.stringIsNullOrEmpty(prestito.getNote());
	}
	
	public static boolean utenteIsEmpty(Utente utente) {
		return GeneralUtils.stringIsNullOrEmpty(utente.getNome())
				&& GeneralUtils.stringIsNullOrEmpty(utente.getCognome())
				&& GeneralUtils.stringIsNullOrEmpty(utente.getCodiceFiscale())
				&& GeneralUtils.stringIsNullOrEmpty(utente.getEmail())
				&& GeneralUtils.stringIsNullOrEmpty(utente.getTelefono())
				&& GeneralUtils.stringIsNullOrEmpty(utente.getIndirizzo());
	}
	
	public static boolean autoreAreNotNullValuesEmpty(Autore autore) {
		return GeneralUtils.stringIsNullOrEmpty(autore.getCognome());
	}
	
	public static boolean editoreAreNotNullValuesEmpty(Editore editore) {
		return GeneralUtils.stringIsNullOrEmpty(editore.getDenominazione());
	}
	
	public static boolean libroAreNotNullValuesEmpty(Libro libro) {
		return GeneralUtils.stringIsNullOrEmpty(libro.getTitolo());
	}
	
	public static boolean prestitoAreNotNullValuesEmpty(Prestito prestito) {
		return prestito.getIdLibro() == null
				|| prestito.getIdUtente() == null;
	}
	
	public static boolean utenteAreNotNullValuesEmpty(Utente utente) {
		return GeneralUtils.stringIsNullOrEmpty(utente.getCognome())
				&& GeneralUtils.stringIsNullOrEmpty(utente.getEmail());
	}
	
}
