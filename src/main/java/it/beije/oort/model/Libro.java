package it.beije.oort.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import it.beije.oort.database.DatabaseController;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="libri")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Libro implements IBibliotecaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String titolo;

    @Column
    private String descrizione;

    @Column(name = "anno_pubblicazione")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonProperty("anno_pubblicazione")
    private Date annoPubblicazione;

    @Column(name = "id_autore")
    @JsonProperty("id_autore")
    private Long idAutore;

    @Column(name = "id_editore")
    @JsonProperty("id_editore")
    private Long idEditore;

    public Autore getAutore(){
        if (idAutore != null){
            return DatabaseController.getAutore(idAutore);
        } else return null;
    }

    public Editore getEditore(){
        if (idEditore != null){
            return DatabaseController.getEditore(idEditore);
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

    public Date getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(Date anno_pubblicazione) {
        this.annoPubblicazione = anno_pubblicazione;
    }

    public Long getIdAutore() {
        return idAutore;
    }

    public void setIdAutore(Long id_autore) {
        this.idAutore = id_autore;
    }

    public Long getIdEditore() {
        return idEditore;
    }

    public void setIdEditore(Long id_editore) {
        this.idEditore = id_editore;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ") Titolo: " + titolo +
                ". Anno: " + annoPubblicazione +
                ". ID Autore: " + idAutore +
                ". ID Editore: " + idEditore +
                ".\n\tDescrizione: " + descrizione;
    }

    @JsonIgnore
    public boolean isEmpty(){
        return !titolo.equals("") && annoPubblicazione != null
                && idAutore >= 0 && idEditore >= 0 && !descrizione.equals("");
    }
}
