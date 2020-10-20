package it.beije.oort.bm.library.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name = "author")
public class Author implements Comparable<Author>, Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_author")
	private Integer id;
	@Column
	private String surname;
	@Column
	private String name;
	@Column(name = "date_of_birth")
	private String dateOfBirth;
	@Column(name = "date_of_death")
	private String dateOfDeath;
	@Column
	private String biography;
	
	
	public int getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@JsonGetter("date_of_birth")
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	@JsonSetter("date_of_birth")
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@JsonGetter("date_of_death")
	public String getDateOfDeath() {
		return dateOfDeath;
	}

	@JsonSetter("date_of_death")
	public void setDateOfDeath(String dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}


	public String getBiography() {
		return biography;
	}


	public void setBiography(String biography) {
		this.biography = biography;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("| ").append("id: ").append(id).append(" | ")
			.append("surname : ").append(this.surname).append(" | ")
			.append("name : ").append(this.name).append(" | ")
			.append("date of birth : ").append(this.dateOfBirth).append(" | ")
			.append("date of death : ").append(this.dateOfDeath).append(" |\n")
			.append("\t| Biography : ").append(biography).append(" |");
		
		return builder.toString();
	}

	@Override
	public int compareTo(Author a) {
		int comp = a.surname.compareTo(a.getSurname());
		if(comp == 0) comp = this.name.compareTo(a.getName());
		return comp;
	}

}
