package entidades;

import java.sql.Date;

public class Users {

	private int Id;
	private String fullName;
	private String gender;
	private String email;
	private Date birthDay;
	private String cpf;
	private String password;
	private int address_id;

	public Users(int id, String fullName, String gender, String email, Date birthDay, String cpf, String password,
			int address_id) {
		super();
		Id = id;
		this.fullName = fullName;
		this.gender = gender;
		this.email = email;
		this.birthDay = birthDay;
		this.cpf = cpf;
		this.password = password;
		this.address_id = address_id;
	}

	public Users(String fullName, String gender, String email, Date birthDay, String cpf, String password,
			int address_id) {
		super();
		this.fullName = fullName;
		this.gender = gender;
		this.email = email;
		this.birthDay = birthDay;
		this.cpf = cpf;
		this.password = password;
		this.address_id = address_id;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
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

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	@Override
	public String toString() {
		return "Users [Id=" + Id + ", fullName=" + fullName + ", gender=" + gender + ", email=" + email + ", birthDay="
				+ birthDay + ", cpf=" + cpf + ", password=" + password + ", address_id=" + address_id + "]";
	}

}
