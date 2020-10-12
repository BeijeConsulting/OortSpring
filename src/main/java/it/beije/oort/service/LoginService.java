package it.beije.oort.service;

import it.beije.oort.database.DatabaseController;
import it.beije.oort.model.Utente;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class LoginService {

    public Utente getUser(String cfMail, String password, Model model){
        Utente utente = null;
        if (DatabaseController.getUtente(cfMail) != null){
            utente = DatabaseController.getUtente(cfMail);
        } else if (DatabaseController.getUtenteFromMail(cfMail) != null){
            utente = DatabaseController.getUtenteFromMail(cfMail);
        } else {
            return null;
        }
        // verifica la password
        if (utente.getPassword().equals(password)){
            return utente;
        } else {
            return null;
        }
    }
}
