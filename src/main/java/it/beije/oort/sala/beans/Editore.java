package it.beije.oort.sala.beans;

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
@Table(name = "editori")
@JsonInclude(Include.NON_NULL)
public class Editore implements Databasable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_editore")
	@JsonProperty("id_editore")
	private Integer idEditore;
	
	@Column
	private String denominazione;
	
	@Column
	private String descrizione;
	
	public Editore() {
		this(null, "", "");
	}
	
	public Editore(Integer idEditore, String denominazione, String descrizione) {
		super();
		this.idEditore = idEditore;
		this.denominazione = denominazione;
		this.descrizione = descrizione;
	}
	public Integer getIdEditore() {
		return idEditore;
	}
	public void setIEditore(Integer idEditore) {
		this.idEditore = idEditore;
	}
	public String getDenominazione() {
		return denominazione;
	}
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String toString() {
		return "Editore [id_editore=" + idEditore + ", denominazione=" + denominazione + "]";
	}
}