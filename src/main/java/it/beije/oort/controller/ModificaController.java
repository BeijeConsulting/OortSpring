package it.beije.oort.controller;

import it.beije.oort.model.Libro;
import it.beije.oort.service.LibroModifierService;
import it.beije.oort.service.LibroService;
import it.beije.oort.utils.ListManagerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

//////////////////////////////////////////////////////////////
// CONTROLLER PER PAGINE DI MODIFICA DEI SINGOLI OGGETTI
//////////////////////////////////////////////////////////////
@Controller
public class ModificaController {



    @Autowired
    private LibroModifierService libroModifierService;

    @Autowired
    private LibroService libroService;


    @GetMapping(value = "/libro/{id}/modifica")
    public String getModificaLibro(Model model,
            HttpSession session,
            @PathVariable Long id){

        System.out.println("GetMapping modifica");
        Libro libro = libroService.load(id);
        System.out.println("Libro caricato");

        if (libro != null){
            model.addAttribute("libro", libro);
        }
        ListManagerUtils.updateLists(session);
        return "modifica/modificaLibro";
    }

    @PostMapping(value = "/libro/{id}/modifica")
    public String modificaLibro(Libro libro,
                                @PathVariable Long id){

        System.out.println("post modifica libro");
        System.out.println(libro.getAnnoPubblicazione());
        libroModifierService.update(libro, id);

        System.out.println("libro aggiornato");

        return "redirect:/libro/" + id;
    }
}
