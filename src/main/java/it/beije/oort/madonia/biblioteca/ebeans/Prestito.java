package it.beije.oort.madonia.biblioteca.ebeans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prestiti")
public class Prestito implements Ebeans {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "libro")
	private Integer idLibro;
	
	@Column(name = "utente")
	private Integer idUtente;
	
	@Column(name = "data_inizio")
	private Date dataInizio;
	
	@Column(name = "data_fine")
	private Date dataFine;
	
	@Column(name = "note")
	private String note;
	
	public Prestito() {}
	
	public Prestito(Integer idLibro, Integer idUtente) {
		this(idLibro, idUtente, null);
	}
	
	public Prestito(Integer idLibro, Integer idUtente, Date dataInizio) {
		this(idLibro, idUtente, dataInizio, null);
	}
	
	public Prestito(Integer idLibro, Integer idUtente, Date dataInizio, Date dataFine) {
		this(idLibro, idUtente, dataInizio, dataFine, null);
	}
	
	public Prestito(Integer idLibro, Integer idUtente, Date dataInizio, Date dataFine, String note) {
		this.setIdLibro(idLibro);
		this.setIdUtente(idUtente);
		this.setDataInizio(dataInizio);
		this.setDataFine(dataFine);
		this.setNote(note);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder().append("Prestito [");

		sb.append("id libro: ");
		if(idLibro == 0) {
			sb.append(idLibro);
		} else {
			sb.append("\"").append(idLibro).append("\"");
		}

		sb.append(" - ").append("id utente: ");
		if(idUtente == 0) {
			sb.append(idUtente);
		} else {
			sb.append("\"").append(idUtente).append("\"");
		}

		sb.append(" - ").append("data_inizio: ");
		if(dataInizio == null) {
			sb.append(dataInizio);
		} else {
			sb.append("\"").append(dataInizio).append("\"");
		}

		sb.append(" - ").append("data_fine: ");
		if(dataFine == null) {
			sb.append(dataFine);
		} else {
			sb.append("\"").append(dataFine).append("\"");
		}

		sb.append(" - ").append("note: ");
		if(note == null) {
			sb.append(note);
		} else {
			sb.append("\"").append(note).append("\"");
		}

		sb.append("]");

		return sb.toString();
	}
}