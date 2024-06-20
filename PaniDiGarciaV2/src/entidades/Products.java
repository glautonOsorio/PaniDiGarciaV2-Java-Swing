package entidades;

public class Products {

	private int Id;
	private String name;
	private String description;
	private double price;
	private String image;
	private int category_id;
	private int user_id;

	public Products(int id, String name, String description, double price, String image, int category_id, int user_id) {
		super();
		Id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
		this.category_id = category_id;
		this.user_id = user_id;
	}

	public Products(String name, String description, double price, String image, int category_id, int user_id) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
		this.category_id = category_id;
		this.user_id = user_id;
	}

	public int getId() {
		return Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Products [Id=" + Id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", image=" + image + ", category_id=" + category_id + ", user_id=" + user_id + "]";
	}

}
