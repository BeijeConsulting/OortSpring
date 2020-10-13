package it.beije.oort.madonia.biblioteca.utilities;

import it.beije.oort.madonia.biblioteca.ebeans.Autore;
import it.beije.oort.madonia.biblioteca.ebeans.Editore;

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
	
	public static boolean autoreAreNotNullValuesEmpty(Autore autore) {
		return GeneralUtils.stringIsNullOrEmpty(autore.getCognome());
	}
	
	public static boolean editoreAreNotNullValuesEmpty(Editore editore) {
		return GeneralUtils.stringIsNullOrEmpty(editore.getDenominazione());
	}
	
}
