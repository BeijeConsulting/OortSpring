package it.beije.oort.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "autori")
public class Autore implements IBibliotecaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String nome;

    @Column
    private String cognome;

    @Column
    private String biografia;

    @Column
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dataNascita;

    @Column
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dataMorte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date data_nascita) {
        this.dataNascita = data_nascita;
    }

    public Date getDataMorte() {
        return dataMorte;
    }

    public void setDataMorte(Date data_morte) {
        this.dataMorte = data_morte;
    }

    public String toString(){
        return "ID: " + id +
                ") Nome: " + nome +
                ". Cognome: " + cognome +
                ". Data di Nascita: " + dataNascita +
                ". Data di Morte: " + dataMorte +
                ".\n\tBiografia: " + biografia;
    }
}
