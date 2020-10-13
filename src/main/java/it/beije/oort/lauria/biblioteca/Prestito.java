package it.beije.oort.lauria.biblioteca;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prestiti")
public class Prestito {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "idLibro")
	private int id_libro;
	
	@Column(name = "idUtente")
	private int id_utente;
	
	@Column(name = "dataInizio")
	private LocalDate data_inizio;
	
	@Column(name = "dataFine")
	private LocalDate data_fine;
	
	@Column(name = "note")
	private String note;

	public Prestito() {}

	public Prestito(int id, int id_libro, int id_utente, LocalDate data_inizio, LocalDate data_fine, String note) {
		this.id = id;
		this.id_libro = id_libro;
		this.id_utente = id_utente;
		this.data_inizio = data_inizio;
		this.data_fine = data_fine;
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

	public int getId_utente() {
		return id_utente;
	}

	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
	}

	public LocalDate getData_inizio() {
		return data_inizio;
	}

	public void setData_inizio(LocalDate data_inizio) {
		this.data_inizio = data_inizio;
	}

	public LocalDate getData_fine() {
		return data_fine;
	}

	public void setData_fine(LocalDate data_fine) {
		this.data_fine = data_fine;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
	
}
