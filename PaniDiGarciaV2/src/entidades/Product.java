package entidades;

public class Product {
	public enum Categories {
		Breads, Cakes, Sweets, Savorys, Pies
	}

	private int Id;
	private String name;
	private String description;
	private double price;
	private Categories categories;
	private User user;

	public Product(int id, String name, String description, double price, String image, Categories categories,
			User user) {
		super();
		Id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.categories = categories;
		this.user = user;
	}

	public Product() {
	}

	public Product(String name, String description, double price, String image, Categories categories, User user) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
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

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Products [Id=" + Id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", category=" + categories + ", user_id=" + user + "]";
	}

}
