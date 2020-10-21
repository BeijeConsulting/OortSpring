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
@Table(name = "libri")
@JsonInclude(Include.NON_NULL)
public class Libro implements Databasable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_libro")
	@JsonProperty("id_libro")
	private Integer idLibro;
	
	@Column(name="id_autore")
	@JsonProperty("id_autore")
	private Integer idAutore;
	
	@Column(name="id_editore")
	@JsonProperty("id_editore")
	private Integer idEditore;
	
	@Column
	private String titolo;
	
	@Column
	private String descrizione;
	
	@Column
	private Short anno;
	
	public Libro() {
		this(null, null, null, "", "", null);
	}
	
	public Libro(Integer id_libro, String titolo) {
		this(id_libro, null, null, titolo, "", null);
	}
	
	public Libro(Integer idLibro, Integer idAutore,Integer idEditore,
			String titolo, String descrizione, Short anno) {
		this.idLibro=idLibro;
		this.idAutore=idAutore;
		this.idEditore=idEditore;
		this.titolo=titolo;
		this.descrizione=descrizione;
		this.anno=anno;
	}
	
	public Integer getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
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
	public Short getAnno() {
		return anno;
	}
	public void setAnno(Short anno) {
		this.anno = anno;
	}

	public String toString() {
		return "Libro [id_libro=" + idLibro + ", id_autore=" + idAutore + ", titolo=" + titolo + ", anno=" + anno
				+ "]";
	}
	
	
}
