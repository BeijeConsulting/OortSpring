package it.beije.oort.kirolosmater.biblioteca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "editore")
public class Editore {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ideditore")
	private Integer id;
	
	@Column(name = "denominazione")
	private String denominazione;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
}
