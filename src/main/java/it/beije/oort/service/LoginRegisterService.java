package it.beije.oort.service;

import it.beije.oort.model.Utente;
import it.beije.oort.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginRegisterService {
    @Autowired
    private LoginRepository loginRepository;

    public Utente getUser(String cfMail, String password){
        if (loginRepository.findByCodiceFiscaleAndPassword(cfMail, password) != null){
            return loginRepository.findByCodiceFiscaleAndPassword(cfMail, password);
        } else if (loginRepository.findByEmailAndPassword(cfMail, password) != null){
            return loginRepository.findByCodiceFiscaleAndPassword(cfMail, password);
        } else {
            return null;
        }
    }

    public boolean createUser(Utente utente){
        // todo controlli?
        try{
            loginRepository.save(utente);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
