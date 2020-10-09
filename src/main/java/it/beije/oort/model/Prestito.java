package it.beije.oort.model;

import it.beije.oort.database.DatabaseController;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "prestiti")
public class Prestito implements IBibliotecaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "data_inizio")
    private Date dataInizio;

    @Column(name = "data_fine")
    private Date dataFine;

    @Column
    private String note;

    @Column(name = "cf_utente")
    private String cfUtente;

    @Column(name = "id_libro")
    private Long idLibro;

    public Utente getUtente(){
        return DatabaseController.getUtente(cfUtente);
    }

    public Libro getLibro(){
        return DatabaseController.getLibro(idLibro);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date data_inizio) {
        this.dataInizio = data_inizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date data_fine) {
        this.dataFine = data_fine;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCfUtente() {
        return cfUtente;
    }

    public void setCfUtente(String cf_utente) {
        this.cfUtente = cf_utente;
    }

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long id_libro) {
        this.idLibro = id_libro;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ") Data di Inizio Prestito: " + dataInizio +
                ". Data di Fine Prestito: " + dataFine +
                ". Codice Fiscale Utente: " + cfUtente +
                ". ID Libro: " + idLibro +
                ".\n\tNote: " + note;
    }
}
