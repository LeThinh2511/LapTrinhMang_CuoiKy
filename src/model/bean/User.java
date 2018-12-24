package model.bean;

public class User {
	private long id;
	private String pass;
	private String email;
	public User() {
		super();
	}
	
	public User(long id, String pass, String email) {
		super();
		this.id = id;
		this.pass = pass;
		this.email = email;
	}
	
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}