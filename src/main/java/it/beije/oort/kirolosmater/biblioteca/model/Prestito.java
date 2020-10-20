package it.beije.oort.kirolosmater.biblioteca.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prestito")
public class Prestito {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idprestito")
	private Integer id;	
	
	@Column(name="libro")
	private String libro;
	
	@Column(name="utente")
	private String utente;
	
	@Column(name="data_inizio")
	private LocalDate dataInizio;
	
	@Column(name="data_fine")
	private LocalDate dataFine;
	
	@Column(name="note")
	private String note;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLibro() {
		return libro;
	}
	public void setLibro(String libro) {
		this.libro = libro;
	}
	public String getUtente() {
		return utente;
	}
	public void setUtente(String utente) {
		this.utente = utente;
	}
	public LocalDate getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}
	public LocalDate getDataFine() {
		return dataFine;
	}
	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
