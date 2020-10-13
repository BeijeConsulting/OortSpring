package it.beije.oort.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BiblioIndexController {
    @GetMapping(value = "/biblio")
    public String serveIndex(){
        return "biblio_index";
    }
}
