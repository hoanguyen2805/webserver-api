package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Book database table.
 * 
 */
@Entity(name="Book")
//@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	private String theLoai;

	public Book() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTheLoai() {
		return this.theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	public Book(int id, String name, String theLoai) {
		super();
		this.id = id;
		this.name = name;
		this.theLoai = theLoai;
	}

}