package it.beije.oort.restcontroller;

import it.beije.oort.model.IBibliotecaModel;
import it.beije.oort.repository.EditoreRepository;
import it.beije.oort.repository.PrestitoRepository;
import it.beije.oort.repository.UtenteRepository;
import it.beije.oort.service.AuthorService;
import it.beije.oort.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Solo un test
 */
@RestController
@RequestMapping("/api")
public class EverythingRestController {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private EditoreRepository editoreRepository;
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private PrestitoRepository prestitoRepository;

    @GetMapping("/getAll")
    public List<? extends IBibliotecaModel> getEverything(){
        List<IBibliotecaModel> list = new ArrayList<>();
        list.addAll(bookService.getAll());
        list.addAll(authorService.getAll());
        list.addAll(editoreRepository.findAll());
        list.addAll(utenteRepository.findAll());
        list.addAll(prestitoRepository.findAll());
        return list;
    }
}
