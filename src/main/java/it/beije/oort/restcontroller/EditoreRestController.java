package it.beije.oort.restcontroller;

import it.beije.oort.model.Editore;
import it.beije.oort.repository.EditoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EditoreRestController {
    @Autowired
    private EditoreRepository editoreRepository;

    @GetMapping("/getEditori")
    public List<Editore> getAll(){
        return editoreRepository.findAll();
    }
}
