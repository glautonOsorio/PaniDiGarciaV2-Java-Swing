package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidades.Product;
import entidades.Product.Categories;

public class ProductsDao {

	public List<Product> listarProducts() {
		List<Product> products = new ArrayList<>();
		String query = "SELECT * FROM products";
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
				products.add(new Product(id, name, description, price, categoriesString, categories, null));
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
	/*
	 * public int inserirPessoa(Product newProduct) {
	 * 
	 * // SQL String insert =
	 * "INSERT INTO products (nome, idade, email) VALUES (?, ?, ?)";
	 * 
	 * try { Connection con = getConexao(); PreparedStatement pst =
	 * con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
	 * pst.setString(1, newProduct.getNome()); pst.setInt(2, newProduct.getIdade());
	 * pst.setString(3, newProduct.getEmail()); pst.executeUpdate();
	 * 
	 * // Pegando a chave ResultSet rs = pst.getGeneratedKeys(); int chaveGerada; if
	 * (rs.next()) { chaveGerada = rs.getInt(1); return chaveGerada; } rs.close();
	 * pst.close(); con.close();
	 * 
	 * } catch (ClassNotFoundException e) { e.printStackTrace(); } catch (Exception
	 * e) { e.printStackTrace(); }
	 * 
	 * return 0;
	 * 
	 * }
	 * 
	 * public void excluirPessoa(int id) { String delete =
	 * "Delete FROM products WHERE (id = ?)"; try { Connection con = getConexao();
	 * PreparedStatement pst = con.prepareStatement(delete); pst.setInt(1, id);
	 * pst.executeUpdate();
	 * 
	 * pst.close(); con.close(); } catch (Exception e) { System.out.println(e); } }
	 * 
	 * public Product pesquisarPorId(int id) { Product product = new Product();
	 * String query = "SELECT * FROM products WHERE Id = ?"; try { Connection con =
	 * getConexao(); PreparedStatement pst = con.prepareStatement(query);
	 * pst.setInt(1, id); ResultSet rs = pst.executeQuery(); while (rs.next()) { id
	 * = rs.getInt(1); String nome = rs.getString(2); int idade = rs.getInt(3);
	 * String email = rs.getString(4); product = new Product(id, nome, idade,
	 * email); } pst.close(); pst.close(); con.close(); } catch (Exception e) {
	 * System.out.println(e); } return product; }
	 * 
	 * public void alterarPessoa(Product updatedProduct) {
	 * 
	 * String update =
	 * "UPDATE pessoas SET nome = ?, idade = ?, email = ? WHERE Id = ?"; try {
	 * Connection con = getConexao(); PreparedStatement pst =
	 * con.prepareStatement(update); pst.setString(1, pessoaAlterado.getNome());
	 * pst.setInt(2, pessoaAlterado.getIdade()); pst.setString(3,
	 * pessoaAlterado.getEmail()); pst.setInt(4, pessoaAlterado.getId());
	 * pst.executeUpdate();
	 * 
	 * pst.close(); con.close(); } catch (Exception e) { System.out.println(e); }
	 * 
	 * }
	 * 
	 * public ArrayList<Product> pesquisar(String coluna, String valor) {
	 * ArrayList<Product> products = new ArrayList<>();
	 * 
	 * String query = null; if (coluna.equals("email")) { query =
	 * "SELECT * FROM pessoas WHERE email LIKE '%" + valor + "%'"; } else if
	 * (coluna.equals("nome")) { query = "SELECT * FROM pessoas WHERE nome LIKE '%"
	 * + valor + "%'"; }
	 * 
	 * try { Connection con = getConexao(); PreparedStatement pst =
	 * con.prepareStatement(query); ResultSet rs = pst.executeQuery();
	 * 
	 * while (rs.next()) { int id = rs.getInt(1); String nome = rs.getString(2); int
	 * idade = rs.getInt(3); String email = rs.getString(4); pessoas.add(new
	 * Pessoa(id, nome, idade, email)); } rs.close(); pst.close(); con.close(); }
	 * catch (Exception e) { System.out.println(e); } return pessoas; }
	 */

}
