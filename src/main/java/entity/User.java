package entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "`User`")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String admin;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdmin() {
		return this.admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User(int id, String username, String password, String admin) {
		super();
		this.id = id;
		this.admin = admin;
		this.password = password;
		this.username = username;
	}

}