package it.beije.oort.sala.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "utenti")
@JsonInclude(Include.NON_NULL)
public class Utente implements Databasable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_utente")
	@JsonProperty("id_utente")
	private Integer idUtente;
	@Column
	private String nome;
	@Column
	private String cognome;
	@Column
	private String email;
	@Column(name="codice_fiscale")
	@JsonProperty("codice_fiscale")
	private String codiceFiscale;
	@Column
	private String telefono;
	@Column
	private String indirizzo;
	@Column
	@JsonIgnore
	private String password;
	@Column
	private boolean admin;

	public Utente() {
		this(null, "","","","","","","",false);
	}
	
	public Utente(Integer idUtente, String nome, String cognome, String codiceFiscale, 
				String email, String telefono, String indirizzo, String password, boolean admin) {
		super();
		this.idUtente = idUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.codiceFiscale = codiceFiscale;
		this.telefono = telefono;
		this.indirizzo = indirizzo;
		this.password = password;
		this.admin = admin;
	}
	
	public Integer getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public String toString() {
		return "Utente [id_utente=" + idUtente + ", nome=" + nome + ", cognome=" 
				+ cognome + ", email=" + email + "]";
	}
}
