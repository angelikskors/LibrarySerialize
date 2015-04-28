package ua.org.angelikskors;

import java.io.Serializable;

public class LibraryList implements Serializable {
	private String author;
	private String name;
	private int year;

	public LibraryList(String author, String name, int year) {
		setAuthor(author);
		setName(name);
		setYear(year);
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setYear(int year) {

		this.year = year;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

}