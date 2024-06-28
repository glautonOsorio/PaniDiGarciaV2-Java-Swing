package entidades;

import java.sql.Date;

public class User {
	public enum Gender {
		Male, Female, Other
	}

	private int Id;
	private String fullName;
	private Gender gender;
	private String email;
	private Date birthDay;
	private String cpf;
	private String password;
	private Address address;

	public User(int id, String fullName, Gender gender, String email, Date birthDay, String cpf, String password,
			Address address) {
		super();
		this.Id = id;
		this.fullName = fullName;
		this.gender = gender;
		this.email = email;
		this.birthDay = birthDay;
		this.cpf = cpf;
		this.password = password;
		this.address = address;
	}

	public User() {
	}


	public User(String fullName, Gender gender, String email, Date birthDay, String cpf, String password,
			Address address) {
		super();
		this.fullName = fullName;
		this.gender = gender;
		this.email = email;
		this.birthDay = birthDay;
		this.cpf = cpf;
		this.password = password;
		this.address = address;
	}

	public User(int id, String fullName, Gender gender, String email, Date birthDay, String cpf, String password) {
		super();
		this.Id = id;
		this.fullName = fullName;
		this.gender = gender;
		this.email = email;
		this.birthDay = birthDay;
		this.cpf = cpf;
		this.password = password;

	}

	public int getId() {
		return Id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", fullName=" + fullName + ", gender=" + gender + ", email=" + email + ", birthDay="
				+ birthDay + ", cpf=" + cpf + ", password=" + password + ", address=" + address + "]";
	}

}
