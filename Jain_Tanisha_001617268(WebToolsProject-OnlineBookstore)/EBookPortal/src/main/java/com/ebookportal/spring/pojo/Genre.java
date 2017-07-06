package com.ebookportal.spring.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="genre_table")
public class Genre {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="genreID", unique = true, nullable = false)
    private long genreID;
	
	@Column(name="genreName")
    private String genreName;
    
	@OneToMany(fetch=FetchType.LAZY, mappedBy="genreId")
	private Set<Book> books = new HashSet<Book>();

    public Genre(String genreName) {
        this.genreName = genreName;
        this.books = new HashSet<Book>();
    }

    Genre() {
    }

    //adding books this way into the genre
    public void addBook(Book book) {
        getBooks().add(book);
    }
    
	public long getGenreID() {
		return genreID;
	}

	public void setGenreID(long genreID) {
		this.genreID = genreID;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
}