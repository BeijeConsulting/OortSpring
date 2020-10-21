package it.beije.oort.madonia.biblioteca.ebeans;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import it.beije.oort.madonia.biblioteca.utilities.GeneralUtils;

@Entity
@Table(name = "autori")
@JsonInclude(Include.NON_NULL)
public class Autore implements Ebeans {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "nome")
	private String nome;
	
	@JsonProperty("data_nascita")
	@Column(name = "data_nascita")
	private Date dataNascita;
	
	@JsonProperty("data_morte")
	@Column(name = "data_morte")
	private Date dataMorte;
	
	@Column(name = "biografia")
	private String biografia;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	
	@JsonGetter("data_nascita")
	public String getDataNascitaFormattata() {
		return dataNascita == null ? null : new SimpleDateFormat("yyyy-MM-dd").format(dataNascita);
	}
	@JsonSetter("data_nascita")
	public void setDataNascitaFormattata(String dataNascita) {
		this.dataNascita = GeneralUtils.stringToSqlDate(dataNascita);
	}
	
	public Date getDataMorte() {
		return dataMorte;
	}
	public void setDataMorte(Date dataMorte) {
		this.dataMorte = dataMorte;
	}
	
	@JsonGetter("data_morte")
	public String getDataMorteFormattata() {
		return dataMorte == null ? null : new SimpleDateFormat("yyyy-MM-dd").format(dataMorte);
	}
	@JsonSetter("data_morte")
	public void setDataMorteFormattata(String dataMorte) {
		this.dataMorte = GeneralUtils.stringToSqlDate(dataMorte);
	}
	
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder().append("Autore [");
		
		sb.append("cognome: ");
		if(cognome == null) {
			sb.append(cognome);
		} else {
			sb.append("\"").append(cognome).append("\"");
		}
		
		sb.append(" - ").append("nome: ");
		if(nome == null) {
			sb.append(nome);
		} else {
			sb.append("\"").append(nome).append("\"");
		}
		
		sb.append(" - ").append("data_nascita: ");
		if(dataNascita == null) {
			sb.append(dataNascita);
		} else {
			sb.append("\"").append(dataNascita).append("\"");
		}
		
		sb.append(" - ").append("data_morte: ");
		if(dataMorte == null) {
			sb.append(dataMorte);
		} else {
			sb.append("\"").append(dataMorte).append("\"");
		}
		
		sb.append(" - ").append("biografia: ");
		if(biografia == null) {
			sb.append(biografia);
		} else {
			sb.append("\"").append(biografia).append("\"");
		}
		
		sb.append("]");
		
		return sb.toString();
	}
}
