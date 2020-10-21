package it.beije.oort.restcontroller;

import it.beije.oort.model.Autore;
import it.beije.oort.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller to map API urls to work with authors (Autore object)
 */
@RestController
@RequestMapping("/api")
public class AuthorRestController {
    @Autowired
    private AuthorService authorService;

    /**
     * Return an Autore object in JSON (GET)
     * @param id the ID of the Autore to return
     * @return an Autore object
     */
    @GetMapping("/getAuthor/{id}")
    public Autore getAutore(@PathVariable Long id){
        Autore a = authorService.load(id);
        if (a != null) return a;
        else throw new NullPointerException("No Autore with such ID");
    }

    /**
     * Obtain a List of every Autore object in the Database
     * @return a List of every Autore object in the Database
     */
    @GetMapping("/getAuthors")
    public List<Autore> getAll(){
        return authorService.getAll();
    }

    @GetMapping("/getAuthors-{name}-{surname}")
    public List<Autore> getByNameAndSurname(@PathVariable String name,
                                            @PathVariable String surname){
        return authorService.getByNameAndSurname(name, surname);
    }

    @GetMapping("/getAuthors-{name}")
    public List<Autore> getByName(@PathVariable String name){
        return authorService.getByName(name);
    }
}
