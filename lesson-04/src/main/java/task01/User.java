package task01;

public class User {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String accessLevel;

	public User(int id, String firstName, String lastName, String email, String password, String accessLevel) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.accessLevel = accessLevel;
	}

	public User(String firstName, String lastName, String email, String password, String accessLevel) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.accessLevel = accessLevel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}

	@Override
	public String toString() {
		return "User id = " + id + ", firstName = " + firstName + ", lastName = " + lastName + ", email = " + email
				+ ", password = " + password + ", accessLevel = " + accessLevel;
	}

}