package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Product;
import entidades.Product.Categories;
import entidades.User;

public class ProductsDao {

	public List<Product> listarProducts() {
		List<Product> products = new ArrayList<>();
		String query = "SELECT * FROM product";
		UsersDao userDao = new UsersDao();
		try {
			Connection con = new ConnectionDao().getConexao();

			PreparedStatement pst = con.prepareStatement(query);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String description = rs.getString(3);
				double price = rs.getDouble(4);
				String categoriesString = rs.getString(5);
				Categories categories = Categories.valueOf(categoriesString);
				int user_id = rs.getInt(6);
				User user = userDao.findById(user_id);
				products.add(new Product(id, name, description, price, categories, user));
			}
			rs.close();
			pst.close();
			con.close();
			return products;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public int insertProduct(Product product) {

		String insert = "INSERT INTO product ( name, description, price, categories, user_id) VALUES(?,?,?,?,?)";
		int primaryKey = 0;
		try (Connection con = new ConnectionDao().getConexao();
				PreparedStatement pst = con.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS)) {

			pst.setString(1, product.getName());
			pst.setString(2, product.getDescription());
			pst.setDouble(3, product.getPrice());
			pst.setString(4, product.getCategories().toString());
			pst.setInt(5, product.getUser().getId());

			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					primaryKey = rs.getInt(1);
				}
				rs.close();
			}

		} catch (ClassNotFoundException |

				SQLException e) {
			e.printStackTrace();
		}

		return primaryKey;
	}

	public boolean updateProduct(Product product) {
		String update = "UPDATE product SET name = ?, description = ?, price = ?, categories = ? WHERE id = ?";
		boolean result = false;

		try (Connection con = new ConnectionDao().getConexao(); PreparedStatement pst = con.prepareStatement(update)) {

			pst.setString(1, product.getName());
			pst.setString(2, product.getDescription());
			pst.setDouble(3, product.getPrice());
			pst.setString(4, String.valueOf(product.getCategories()));
			pst.setInt(5, product.getUser().getId());

			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				result = true;
			} else {
				System.out.println("No product found with the given ID.");
			}

		} catch (Exception e) {
			System.out.println("Error updating product: " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<Product> productsFilter(String valor, User user) {
		ArrayList<Product> products = new ArrayList<>();
		UsersDao userDao = new UsersDao();

		String query = null;

		switch (valor) {
		case "A-Z Order":
			query = "SELECT * FROM product ORDER BY name ASC";
			break;
		case "Z-A Order":
			query = "SELECT * FROM product ORDER BY name DESC";
			break;
		case "Your Products":
			query = "SELECT * FROM product WHERE user_id = ?";
			break;
		case "Lower Price Order":
			query = "SELECT * FROM product ORDER BY price ASC";
			break;
		case "High Price Order":
			query = "SELECT * FROM product ORDER BY price DESC";
			break;
		case "Sweets":
			query = "SELECT * FROM product WHERE categories = 'Sweets'";
			break;
		case "Breads":
			query = "SELECT * FROM product WHERE categories = 'Breads'";
			break;
		case "Cakes":
			query = "SELECT * FROM product WHERE categories = 'Cakes'";
			break;
		case "Savorys":
			query = "SELECT * FROM product WHERE categories = 'Savorys'";
			break;
		case "Pies":
			query = "SELECT * FROM product WHERE categories = 'Pies'";
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + valor);
		}

		try (Connection con = new ConnectionDao().getConexao(); PreparedStatement pst = con.prepareStatement(query);) {
			if (valor.equals("Your Products")) {
				pst.setInt(1, user.getId());
			}

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				double price = rs.getDouble("price");
				String categoriesString = rs.getString("categories");
				Categories categories = Categories.valueOf(categoriesString);
				int userId = rs.getInt("user_id");
				User newUser = userDao.findById(userId);

				Product product = new Product(id, name, description, price, categories, newUser);
				products.add(product);
			}
		} catch (Exception e) {
			System.out.println("Error in pesquisar method: " + e.getMessage());
			e.printStackTrace();
		}

		return products;
	}

}
