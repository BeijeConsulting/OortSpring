package it.beije.oort.controller;

import it.beije.oort.model.Utente;
import it.beije.oort.service.LoginRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    private LoginRegisterService loginRegisterService;

    @PostMapping(value = "/register")
    public String register(Utente utente){
        if (loginRegisterService.createUser(utente)) return "login/registerSuccess";
        else return "login/register";
    }

    @GetMapping(value = "/register")
    public String getRegisterPage(){
        return "login/register";
    }
}
