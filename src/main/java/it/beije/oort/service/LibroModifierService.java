package it.beije.oort.service;

import it.beije.oort.model.Libro;
import it.beije.oort.repository.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroModifierService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private LibroService libroService;

    public void update(Libro nuovo, Long idVecchio){
        System.out.println("nell'update");

        Libro vecchio = libroService.load(idVecchio);

        System.out.println("ottenuto libro vecchio");
        System.out.println("pre:" + vecchio);

//        System.out.println("titolo");
//        vecchio.setTitolo(nuovo.getTitolo());
//        System.out.println("descrizione");
//        vecchio.setDescrizione(nuovo.getDescrizione());
//        System.out.println("autore");
//        vecchio.setIdAutore(nuovo.getIdAutore());
//        System.out.println("editore");
//        vecchio.setIdEditore(nuovo.getIdEditore());
//        System.out.println("anno");
//        vecchio.setAnnoPubblicazione(nuovo.getAnnoPubblicazione());

        try {
            System.out.println(nuovo.getAnnoPubblicazione());
            System.out.println(vecchio.getAnnoPubblicazione());
            BeanUtils.copyProperties(nuovo, vecchio);
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("post:" + vecchio);
        System.out.println("salvo...");
        bookRepository.save(vecchio);
    }
}
