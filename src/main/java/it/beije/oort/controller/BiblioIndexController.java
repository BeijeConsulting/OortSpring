package it.beije.oort.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class BiblioIndexController {
    @GetMapping(value = "/biblio")
    public String serveIndex(HttpSession session){
        if (session.getAttribute("user") == null) return "login";
        return "biblio_index";
    }
}
