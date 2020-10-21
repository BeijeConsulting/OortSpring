package it.beije.oort.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "autori")
@JsonInclude(JsonInclude.Include.NON_NULL)
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

    @Column(name = "data_nascita")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonProperty("data_nascita")
    private Date dataNascita;

    @Column(name = "data_morte")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonProperty("data_morte")
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
