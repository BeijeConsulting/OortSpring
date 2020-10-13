package it.beije.oort.madonia.biblioteca.utilities;

import java.sql.Date;

public class GeneralUtils {
	
	public static boolean stringIsNullOrEmpty(String str) {
		return str == null || str.length() == 0;
	}
	
	public static Date stringToSqlDate(String str) {
		if (GeneralUtils.stringIsNullOrEmpty(str) || str.length() == 0) {
			return null;
		}
		
		return Date.valueOf(str);
	}
}
