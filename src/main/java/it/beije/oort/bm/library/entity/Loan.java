package it.beije.oort.bm.library.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "loan")
public class Loan implements Comparable<Loan>, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_loan")
	private Integer id;
	@ManyToOne(optional=false)
	@JoinColumn(name = "user", referencedColumnName = "id_user")
	private User user;
	@ManyToOne(optional=false)
	@JoinColumn(name = "book", referencedColumnName = "id_book")
	private Book book;
	@Column(name = "start_date")
	private String startDate;
	@Column(name = "end_date")
	private String endDate;
	@Column
	private String notes;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate.toString();
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate.toString();
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("| ").append("id: ").append(id).append(" | ")
			.append("user: ").append(this.user).append(" | ")
			.append("book : ").append(this.book).append(" |\n")
			.append("\t| Notes : ").append(this.notes).append(" |");
		return builder.toString();
	}

	@Override
	public int compareTo(Loan l) {
		return this.startDate.compareTo(l.getStartDate());
	}

}
