package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Address;

public class AddressDao {

	public int insertAddress(Address newAddress) {
		String insert = "INSERT INTO address (zipcode, city, state, street) VALUES (?, ?, ?, ?)";
		int primaryKey = 0;

		try (Connection con = new ConnectionDao().getConexao();
				PreparedStatement pst = con.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS)) {

			pst.setString(1, newAddress.getZipcode());
			pst.setString(2, newAddress.getCity());
			pst.setString(3, newAddress.getState());
			pst.setString(4, newAddress.getStreet());

			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					primaryKey = rs.getInt(1);
				}
				rs.close();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return primaryKey;
	}

	/*
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
