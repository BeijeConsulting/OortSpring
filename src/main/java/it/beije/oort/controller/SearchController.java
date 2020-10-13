package it.beije.oort.controller;

import it.beije.oort.model.Libro;
import it.beije.oort.service.search.BookSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookSearchService bookSearchService;

    // GET
    @GetMapping(value = "/search")
    public String getSearch(){
        return "search/search";
    }

    @GetMapping(value = "/search/libro")
    public String getSearchLibro(){
        log.info("Get Search per Libro");
        return "search/searchBook";
    }

    @GetMapping(value = "/search/autore")
    public String getSearchAutore(){
        return "search/searchAutore";
    }

    // POST
    @PostMapping(value = "/search/libro")
    public String searchLibro(HttpServletRequest request,
                                 Model model){
        log.info("Post per Search Libro");

        model.addAttribute("libri", bookSearchService.search(request));

        return "liste/listLibri";
    }
}