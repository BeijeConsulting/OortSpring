package it.beije.oort.lauria.biblioteca;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@JsonInclude(Include.NON_NULL)
@Table(name = "libri")
public class Libro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "titolo")
	private String titolo;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	@Column(name = "idAutore")
	private Integer id_autore;
	
	@Column(name = "idEditore")
	private Integer id_editore;
	
	@Column(name = "anno")
	private String anno;
	
	
	public Libro() {}
	
	public Libro(Integer id, String titolo, String descrizione, Integer id_autore, Integer id_editore, String anno) {
		this.id = id;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.id_autore = id_autore;
		this.id_editore = id_editore;
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
	
	
	public Integer getId_autore() {
		return id_autore;
	}
	public void setId_autore(Integer id_autore) {
		this.id_autore = id_autore;
	}
	
	
	public Integer getId_editore() {
		return id_editore;
	}
	public void setId_editore(Integer id_editore) {
		this.id_editore = id_editore;
	}
	
	
	public String getAnno() {
		return anno;
	}
	public void setAnno(String anno) {
		this.anno = anno;
	}
	
	public String toString() {
	StringBuilder builder = new StringBuilder("libro [");
	builder.append("titolo : ").append(this.titolo)
		.append(" - descrizione : ").append(this.descrizione)
		.append(" - id autore : ").append(this.id_autore)
		.append(" - id editore : ").append(this.id_editore)
		.append(" - anno : ").append(this.anno).append("]");
	
	return builder.toString();
}

}
