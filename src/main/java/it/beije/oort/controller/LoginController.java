package it.beije.oort.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    // Il get stampa la pagina base, il post elabora la richiesta di login e rimanda alle pagine successive
    @GetMapping(value = "/login")
    public String showLogin(HttpServletRequest request){
        if (request.getSession().getAttribute("user") != null) return "index";


        return "";
    }

    @PostMapping(value = "/login")
    public String logUser(HttpServletRequest request){
        if (request.getSession().getAttribute("user") != null) return "index";

        return "";
    }
}
