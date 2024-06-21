package entidades;

public class Products {

	private int Id;
	private String name;
	private String description;
	private double price;
	private String image;
	private Categories categories;
	private Users user;

	public Products(int id, String name, String description, double price, String image, Categories categories,
			Users user) {
		super();
		Id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
		this.categories = categories;
		this.user = user;
	}

	public Products(String name, String description, double price, String image, Categories categories, Users user) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
		this.categories = categories;
		this.user = user;
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

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Products [Id=" + Id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", image=" + image + ", category_id=" + categories + ", user_id=" + user + "]";
	}

}
