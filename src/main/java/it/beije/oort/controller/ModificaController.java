package it.beije.oort.controller;

import it.beije.oort.model.Libro;
import it.beije.oort.service.LibroModifierService;
import it.beije.oort.service.LibroService;
import it.beije.oort.utils.ListManagerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LibroModifierService libroModifierService;

    @Autowired
    private LibroService libroService;


    @GetMapping(value = "/libro/{id}/modifica")
    public String getModificaLibro(Model model,
            HttpSession session,
            @PathVariable Long id){

        log.info("Richiesta GET per pagina di modifica libro.");
        Libro libro = libroService.load(id);
        if (libro != null){
            model.addAttribute("libro", libro);
            log.info("Libro da modificare caricato con successo.");
        }
        ListManagerUtils.updateLists(session);
        return "modifica/modificaLibro";
    }

    @PostMapping(value = "/libro/{id}/modifica")
    public String modificaLibro(Libro libro,
                                @PathVariable Long id){

        log.info("Richiesta POST per pagina di modifica libro.");
        libroModifierService.update(libro, id);
        log.info("Libro aggiornato.");
        return "redirect:/libro/" + id;
    }
}
