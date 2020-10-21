package it.beije.oort.service;

import it.beije.oort.model.Prestito;
import it.beije.oort.repository.PrestitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestitoService {
    @Autowired
    private PrestitoRepository prestitoRepository;

    public Prestito get(Long id){
        return prestitoRepository.findById(id).orElse(null);
    }

    public List<Prestito> getAllByCfUtente(String cfUtente){
        return prestitoRepository.getAllByCfUtente(cfUtente);
    }

    public List<Prestito> getAll(){return prestitoRepository.findAll();}
}
