package it.beije.oort.model;

import it.beije.oort.database.DatabaseController;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="libri")
public class Libro implements IBibliotecaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String titolo;

    @Column
    private String descrizione;

    @Column
    private Date anno_pubblicazione;

    @Column
    private Long id_autore;

    @Column
    private Long id_editore;

    public Autore getAutore(){
        if (id_autore != null){
            return DatabaseController.getAutore(id_autore);
        } else return null;
    }

    public Editore getEditore(){
        if (id_editore != null){
            return DatabaseController.getEditore(id_editore);
        } else return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Date getAnno_pubblicazione() {
        return anno_pubblicazione;
    }

    public void setAnno_pubblicazione(Date anno_pubblicazione) {
        this.anno_pubblicazione = anno_pubblicazione;
    }

    public Long getId_autore() {
        return id_autore;
    }

    public void setId_autore(Long id_autore) {
        this.id_autore = id_autore;
    }

    public Long getId_editore() {
        return id_editore;
    }

    public void setId_editore(Long id_editore) {
        this.id_editore = id_editore;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ") Titolo: " + titolo +
                ". Anno: " + anno_pubblicazione +
                ". ID Autore: " + id_autore +
                ". ID Editore: " + id_editore +
                ".\n\tDescrizione: " + descrizione;
    }
}
