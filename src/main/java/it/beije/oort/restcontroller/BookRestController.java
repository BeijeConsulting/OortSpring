package it.beije.oort.restcontroller;

import it.beije.oort.model.Libro;
import it.beije.oort.service.BookService;
import it.beije.oort.service.search.BookSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contoller to map API urls to work with books (Libro object)
 */
@RestController
@RequestMapping("/api")
public class BookRestController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookSearchService bookSearchService;

    /**
     * Return a Libro object in JSON (GET)
     * @param id the ID of the Libro to return
     * @return a Libro object
     */
    @GetMapping("/getBook/{id}")
    public Libro getLibro(@PathVariable Long id){
        Libro l = bookService.load(id);
        if (l != null) return l;
        else throw new NullPointerException("No Book with such ID");
    }

    /**
     * Obtain a List of every Libro object in the Database
     * @return a List of every Libro object in the Database
     */
    @GetMapping("/getBooks")
    public List<Libro> getAllBooks(){
        return bookService.getAll();
    }

    /**
     * Insert a new Libro into the database (POST)
     * @param libro the Libro to save (RequestBody)
     * @return the Libro saved in the database
     */
    @PostMapping("/saveBook")
    public Libro saveLibro(@RequestBody Libro libro){
        return bookService.save(libro);
    }

    /**
     * Update a Libro object with a new Libro object
     * @param newLibro the updated Libro
     * @param id id of the old Libro
     * @return the Libro updated from the Database
     */
    @PutMapping("/updateBook/{id}")
    public Libro updateLibro(@RequestBody Libro newLibro, @PathVariable Long id){
        return bookService.update(newLibro, id);
    }

    /**
     * Delete a Libro from the Database
     * @param id ID of the Libro object to delete
     * @return true if successfully deleted
     */
    @DeleteMapping("/deleteBook/{id}")
    public boolean deleteLibro(@PathVariable Long id){
        return bookService.delete(id);
    }

    /**
     * Returns a List of Libro with a title containing the query
     * @param title the query to search in the title field
     * @return a List of Libro
     */
    @GetMapping("searchByTitle/{title}")
    public List<Libro> searchLibriByTitle(@PathVariable String title){
        return bookSearchService.searchBookByTitle(title);
    }
}
