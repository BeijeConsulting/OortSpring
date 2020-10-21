package it.beije.oort.sala.beans;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "prestiti")
@JsonInclude(Include.NON_NULL)
public class Prestito implements Databasable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_prestito")
	@JsonProperty("id_prestito")
	private Integer idPrestito;
	
	@Column(name="id_libro")
	@JsonProperty("id_libro")
	private Integer idLibro;
	
	@Column(name="id_utente")
	@JsonProperty("id_utente")
	private Integer idUtente;
	
	@Column(name="data_inizio")
	@JsonProperty("data_inizio")
	private LocalDate dataInizio;
	
	@Column(name="data_fine")
	@JsonProperty("data_fine")
	private LocalDate dataFine;
	
	@Column
	private String note;
	
	public Prestito() {
		this(null, null, null, null, null, "");
	}
	
	public Prestito(Integer idPrestito, Integer idLibro, Integer idUtente,
			LocalDate dataInizio, LocalDate dataFine, String note) {
		super();
		this.idPrestito = idPrestito;
		this.idLibro = idLibro;
		this.idUtente = idUtente;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.note = note;
	}

	public Integer getIdPrestito() {
		return idPrestito;
	}
	public void setIdPrestito(Integer idPrestito) {
		this.idPrestito = idPrestito;
	}
	public Integer getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}
	public Integer getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}
	public LocalDate getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}
	public void setDataInizio(String dataInizio) {
		this.dataInizio = LocalDate.parse(dataInizio);
	}
	public LocalDate getDataFine() {
		return dataFine;
	}
	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}
	public void setDataFine(String dataFine) {
		this.dataFine = LocalDate.parse(dataFine);
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String toString() {
		return "Prestito [id_libro=" + idLibro + ", id_utente=" + idUtente + ", data_inizio="
				+ dataInizio + ", data_fine=" + dataFine + "]";
	}
}
