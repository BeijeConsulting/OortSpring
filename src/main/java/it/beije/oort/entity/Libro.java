package it.beije.oort.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//import com.fasterxml.jackson.annotation.JsonGetter;
//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "libro")
@JsonInclude(Include.NON_NULL)

public class Libro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "titolo")
	private String titolo;
	
	@JsonProperty("descrizione_libro")
	@Column(name = "descrizione")
	private String descrizione;
	
	@JsonProperty("id_autore")
	@Column(name = "id_autore")
	private Integer idAutore;
	
	@JsonProperty("id_editore")
	@Column(name = "id_editore")
	private Integer idEditore;
	
	@Column(name = "anno")
	private String anno;
	
	
	public Libro() {}
	
	public Libro(String titolo, String descrizione, Integer idAutore, 
					Integer idEditore, String anno) {
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.idAutore = idAutore;
		this.idEditore = idEditore;
		this.anno = anno;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
	public Integer getIdAutore() {
		return idAutore;
	}
	public void setIdAutore(Integer idAutore) {
		this.idAutore = idAutore;
	}
	
	
	public Integer getIdEditore() {
		return idEditore;
	}
	public void setIdEditore(Integer idEditore) {
		this.idEditore = idEditore;
	}
	
	
	public String getAnno() {
		return anno;
	}
	public void setAnno(String anno) {
		this.anno = anno;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder("libro [");
		builder.append("id : ").append(this.id)	
			.append(" - titolo : ").append(this.titolo)	
			.append(" - descrizione : ").append(this.descrizione)
			.append(" - id_autore : ").append(this.idAutore)
			.append(" - id_editore : ").append(this.idEditore)
			.append(" - anno : ").append(this.anno).append("]");
		return builder.toString();
	}
}
