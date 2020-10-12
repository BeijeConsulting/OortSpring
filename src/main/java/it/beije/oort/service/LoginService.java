package it.beije.oort.service;

import it.beije.oort.model.Utente;
import it.beije.oort.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public Utente getUser(String cfMail, String password, Model model){
        Utente utente = null;
        if (loginRepository.findByCodiceFiscaleAndPassword(cfMail, password) != null){
            return utente = loginRepository.findByCodiceFiscaleAndPassword(cfMail, password);
        } else if (loginRepository.findByEmailAndPassword(cfMail, password) != null){
            return utente = loginRepository.findByCodiceFiscaleAndPassword(cfMail, password);
        } else {
            return null;
        }
    }
}
