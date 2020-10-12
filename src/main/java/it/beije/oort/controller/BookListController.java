package it.beije.oort.controller;

import it.beije.oort.database.DatabaseController;
import it.beije.oort.model.Libro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

// todo cambiare, fare il /visualizza post che rimanda alla pagina list corretta
@Controller
public class BookListController {

    @GetMapping(value = "/visualizza")
    public String getPage(){;
        return "listIndex";
    }

    @PostMapping(value = "/visualizza")
    public String viewList(HttpServletRequest request,
                           Model model){
        String listType = (String) request.getParameter("type");
        List<?> lista = new ArrayList<>();

        if (listType != null){
            switch (listType){
                case "Libri":
                    model.addAttribute("lista", DatabaseController.getAllLibri());
                    return "listLibri";
                   // lista = DatabaseController.getAllLibri();
                   // break;
                case "Autori":
                    lista = DatabaseController.getAllAutori();
                    break;
                case "Editori":
                    lista = DatabaseController.getAllEditori();
                    break;
                case "Utenti":
                    lista = DatabaseController.getAllUtenti();
                    break;
                case "Prestiti":
                    lista = DatabaseController.getAllPrestiti();
                    break;
                default:
                    return "listIndex";
            }
//            model.addAttribute("listType", (String) request.getParameter("type"));
            model.addAttribute("lista", lista);
        }
        return "listIndex";
    }

    @GetMapping(value = "/libri")
    public String userViewGet(Model model){
        model.addAttribute("libri", DatabaseController.getAllLibri());
        return "listLibri";
    }

    @GetMapping(value = "/libri/{id}")
    public String listBook(Model model,
                           @PathVariable Long id){
        Libro libro = DatabaseController.getLibro(id);
        if (libro != null){
            model.addAttribute("libro", libro);
        }
        return "dettagliLibro";
    }
}