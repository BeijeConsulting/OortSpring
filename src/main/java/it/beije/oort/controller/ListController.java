package it.beije.oort.controller;

import it.beije.oort.database.DatabaseController;
import it.beije.oort.model.Autore;
import it.beije.oort.model.Libro;
import it.beije.oort.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * ListController gestisce tutte le richieste per visualizzare liste di oggetti e dettagli dei singoli oggetti.
 * Controlla gli url /visualizza /autori /libri /editori /utenti /prestiti e relativi url di dettaglio con ID.
 */
@Controller
public class ListController {

    @Autowired
    private BookService bookService;

    // Stampa la pagina base per scegliere cosa visualizzare
    @GetMapping(value = "/visualizza")
    public String getPage(){
        return "liste/listIndex";
    }

    // Risponde al form di ogni pagina di listing e ritorna la corretta pagina con redirect
    @PostMapping(value = "/visualizza")
    public String viewList(HttpServletRequest request) {
        String listType = request.getParameter("type");
        if (listType != null) {
            switch (listType) {
                case "Libri":
                    return "redirect:/libri";
                case "Autori":
                    return "redirect:/autori";
                case "Editori":
                    return "redirect:/editori";
                case "Utenti":
                    return "redirect:/utenti";
                case "Prestiti":
                    return "redirect:/prestiti";
            }
        }
        return "liste/listIndex";
    }

    ///////////////////////////////////////////////////
    // CONTROLLER PER PAGINE CHE LISTANO GLI ELEMENTI
    ///////////////////////////////////////////////////
    // todo fare la pagina in ajax, usando come param 2 indici (1*i e 10*i+10)
    // e facendo fare la fetch da JS usando un'api rest che ritorni
    // una lista di libri usando tali indici
    @GetMapping(value = "/libri")
    public String libriList(Model model){
        System.out.println("servo pagina libri");
        model.addAttribute("libri", DatabaseController.getAllLibri());
        return "liste/listLibri";
    }

    @GetMapping(value = "/newList")
    public String newLibriList(){
        System.out.println("servo pagina libri con ajax");
        return "liste/newList";
    }

    @GetMapping(value = "/autori")
    public String autoriList(Model model){
        model.addAttribute("autori", DatabaseController.getAllAutori());
        return "liste/listAutori";
    }

    @GetMapping(value = "/editori")
    public String editoriList(Model model){
        model.addAttribute("editori", DatabaseController.getAllEditori());
        return "liste/listEditori";
    }

    @GetMapping(value = "/utenti")
    public String utentiList(Model model){
        model.addAttribute("utenti", DatabaseController.getAllUtenti());
        return "liste/listUtenti";
    }

    @GetMapping(value = "/prestiti")
    public String prestitiList(Model model){
        model.addAttribute("prestiti", DatabaseController.getAllPrestiti());
        return "liste/listPrestiti";
    }

    //////////////////////////////////////////////////////////////
    // CONTROLLER PER PAGINE DI DETTAGLIO DEI SINGOLI OGGETTI
    //////////////////////////////////////////////////////////////
    @GetMapping(value = "/libro/{id}")
    public String detailLibro(Model model,
                              @PathVariable Long id){

        Libro libro = bookService.load(id);
        if (libro != null){
            model.addAttribute("libro", libro);
        }
        return "dettagli/dettagliLibro";
    }

    @GetMapping(value = "/autore/{id}")
    public String detailAutore(Model model,
                           @PathVariable Long id){

        Autore autore = DatabaseController.getAutore(id);
        if (autore != null){
            model.addAttribute("autore", autore);
        }
        return "dettagli/dettagliAutore";
    }
}