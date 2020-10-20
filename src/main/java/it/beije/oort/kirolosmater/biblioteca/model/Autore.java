package it.beije.oort.kirolosmater.biblioteca.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "autore")
public class Autore {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idautore")
	private Integer id;
	
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "data_nascita")
	private LocalDate dataNascita;
	
	@Column(name = "data_morte")
	private LocalDate dataMorte;
	
	@Column(name = "biografia")
	private String biografia;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}
	public LocalDate getDataMorte() {
		return dataMorte;
	}
	public void setDataMorte(LocalDate dataMorte) {
		this.dataMorte = dataMorte;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
}
