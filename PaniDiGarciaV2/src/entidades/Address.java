package entidades;

public class Address {

	private int Id;
	private String zipcode;
	private String city;
	private String state;
	private String street;

	public Address(int id, String zipcode, String city, String state, String street) {
		super();
		Id = id;
		this.zipcode = zipcode;
		this.city = city;
		this.state = state;
		this.street = street;
	}

	public Address(String zipcode, String city, String state, String street) {
		super();
		this.zipcode = zipcode;
		this.city = city;
		this.state = state;
		this.street = street;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "Address [Id=" + Id + ", zipcode=" + zipcode + ", city=" + city + ", state=" + state + ", street="
				+ street + "]";
	}
	

}
