package it.beije.oort.sala.controller.beans;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "autori")
public class Autore implements Databasable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_autore")
	private Integer idAutore;
	@Column
	private String nome;
	@Column
	private String cognome;
	@Column
	private String biografia;
	@Column(name="data_nascita")
	private LocalDate dataNascita;
	@Column(name="data_morte")
	private LocalDate dataMorte;
	
	public Autore() {
		this(null, "", "", "", null, null);
	}
	
	public Autore(Integer idAutore, String nome, String cognome, String biografia, LocalDate dataNascita,
			LocalDate dataMorte) {
		super();
		this.idAutore = idAutore;
		this.nome = nome;
		this.cognome = cognome;
		this.biografia = biografia;
		this.dataNascita = dataNascita;
		this.dataMorte = dataMorte;
	}
	
	public Integer getIdAutore() {
		return idAutore;
	}
	public void setIdAutore(Integer idAutore) {
		this.idAutore = idAutore;
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
	public LocalDate getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}
	public void setDataNascita(String dataNascita) {
		this.dataNascita = LocalDate.parse(dataNascita);
	}
	public LocalDate getDataMorte() {
		return dataMorte;
	}
	public void setDataMorte(LocalDate dataMorte) {
		this.dataMorte = dataMorte;
	}
	public void setDataMorte(String dataMorte) {
		this.dataMorte = LocalDate.parse(dataMorte);
	}

	public String toString() {
		return "Autore [id_autore=" + idAutore + ", nome=" + nome + ", cognome=" + cognome + "]";
	}
	

}
