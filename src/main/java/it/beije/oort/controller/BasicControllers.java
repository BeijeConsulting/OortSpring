package it.beije.oort.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BasicControllers {
    @GetMapping(value = "/biblio")
    public String serveIndex(){
        return "biblio_list";
    }
    @PostMapping
    public String serveIndexPost(){
        return serveIndex();
    }
}
