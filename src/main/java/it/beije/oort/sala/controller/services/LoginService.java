package it.beije.oort.sala.controller.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.beije.oort.sala.controller.beans.Utente;
import it.beije.oort.sala.controller.db.JPAToolset;

@Service
public class LoginService {

	public Utente checkLogin(String email, String password) {
		List<Object> temp = JPAToolset.selectJPA(email, password);
		if(temp.size()==1) {
			return (Utente)temp.get(0);
		}
		return null;
	}
}
