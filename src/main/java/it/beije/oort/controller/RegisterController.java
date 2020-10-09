package it.beije.oort.controller;

import it.beije.oort.model.Utente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    @PostMapping(value = "/register")
    public String register(Utente utente){
        return "";
    }
}
