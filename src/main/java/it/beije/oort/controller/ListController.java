package it.beije.oort.controller;

import it.beije.oort.database.DatabaseController;
import it.beije.oort.model.Libro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ListController {

    @GetMapping(value = "/books")
    public String listAll(Model model){
        model.addAttribute("booksList", DatabaseController.getAllLibri());
        return "books";
    }

    @GetMapping(value = "/books/{id}")
    public String listBook(Model model,
                           @PathVariable Long id){
        Libro libro = DatabaseController.getLibro(id);
        if (libro != null) model.addAttribute("book", libro);
        return "details";
    }
}
