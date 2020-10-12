package it.beije.oort.madonia.biblioteca.ebeans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "libri")
public class Libro implements Ebeans {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "titolo")
	private String titolo;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	@Column(name = "autore")
	private Integer idAutore;
	
	@Column(name = "editore")
	private Integer idEditore;
	
	@Column(name = "anno")
	private Integer anno;
	
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
	
	public Integer getAnno() {
		return anno;
	}
	public void setAnno(Integer anno) {
		this.anno = anno;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder().append("Libro [");

		sb.append("titolo: ");
		if(titolo == null) {
			sb.append(titolo);
		} else {
			sb.append("\"").append(titolo).append("\"");
		}

		sb.append(" - ").append("descrizione: ");
		if(descrizione == null) {
			sb.append(descrizione);
		} else {
			sb.append("\"").append(descrizione).append("\"");
		}

		sb.append(" - ").append("autore: ");
		if(idAutore == null) {
			sb.append("null");
		} else {
			sb.append("\"").append(idAutore).append("\"");
		}

		sb.append(" - ").append("editore: ");
		if(idEditore == null) {
			sb.append("null");
		} else {
			sb.append("\"").append(idEditore).append("\"");
		}

		sb.append(" - ").append("anno: ");
		if(anno == null) {
			sb.append("null");
		} else {
			sb.append("\"").append(anno).append("\"");
		}

		sb.append("]");

		return sb.toString();
	}
}
