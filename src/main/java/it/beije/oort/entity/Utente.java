package it.beije.oort.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
//import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "utente")
@JsonInclude(Include.NON_NULL)
public class Utente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cognome")
	private String cognome;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="email")
	private String email;

	@JsonIgnore    //con questo non mostra la password
	@Column(name="password")
	private String password;
	
	//ESEMPIO:
//	@JsonProperty("data_nascita") //rinomina data di nascita: nel file jason ci vorrà questo nome
//	@Transient
//	private LocalDate dataNascita;
//	
//	public LocalDate getDataNascita() { //get classico
//		return dataNascita;
//	}
//
//	@JsonGetter("data_nascita") // get aggiuntivo che formatta la data
//	public String getDataNascitaFormattata() {
//		return LocalDate.now().toString();
//	}
	
	
	public Utente() {}
	
	public Utente(String nome, String cognome, String telefono) {
		this(nome, cognome, telefono, "");
	}
	
	public Utente(String nome, String cognome, String telefono, String email) {
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;
	}
	
	public Utente(String nome, String cognome, String telefono, String email, 
			String password) {
		this(nome, cognome, telefono, email);
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@JsonGetter("cognome") //dice di volere il cognome in UpperCase
	public String getCognomeMaiuscolo() {
		return cognome.toUpperCase();
	}
	
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	public String toString() {
		StringBuilder builder = new StringBuilder("utente [");
		builder.append("nome : ").append(this.nome)
			.append(" - cognome : ").append(this.cognome)
			.append(" - telefono : ").append(this.telefono)
			.append(" - email : ").append(this.email).append("]");
		
		return builder.toString();
	}
	
}
