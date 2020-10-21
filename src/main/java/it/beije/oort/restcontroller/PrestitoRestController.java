package it.beije.oort.restcontroller;

import it.beije.oort.model.Prestito;
import it.beije.oort.service.PrestitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PrestitoRestController {
    @Autowired
    private PrestitoService prestitoService;

    @GetMapping("prestito/{id}")
    public Prestito get(@PathVariable Long id){
        return prestitoService.get(id);
    }

    @GetMapping("prestito/byUserCF/{cf}")
    public List<Prestito> getByCfUtente(@PathVariable String cf){
        return prestitoService.getAllByCfUtente(cf);
    }

    @GetMapping("/getPrestiti")
    public List<Prestito> getAll(){return prestitoService.getAll();}
}
