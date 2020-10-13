package it.beije.oort.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {
    @GetMapping(value = "/search")
    public String getSearch(){
        return null;
    }
}