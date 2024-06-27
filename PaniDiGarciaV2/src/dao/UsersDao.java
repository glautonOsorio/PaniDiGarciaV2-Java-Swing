package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.User;
import entidades.User.Gender;

public class UsersDao {

	public int inserirEndereco(User newUser) {
		AddressDao daoAddress = new AddressDao();
		int address_id = daoAddress.insertAddress(newUser.getAddres());

		String insert = "INSERT INTO users (fullname, gender, email, birthday, cpf, password,address_id) VALUES (?,?, ?, ?, ?, ?, ?)";
		int primaryKey = 0;

		try (Connection con = new ConnectionDao().getConexao();
				PreparedStatement pst = con.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS)) {

			pst.setString(1, newUser.getFullName());
			pst.setString(2, newUser.getGender().toString());
			pst.setString(3, newUser.getEmail());
			pst.setDate(4, newUser.getBirthDay());
			pst.setString(5, newUser.getCpf());
			pst.setString(6, newUser.getPassword());
			pst.setInt(7, address_id);

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

	public User findById(int id) {

		String sql = "SELECT id,fullName,gender,email,birthDay,cpf,password FROM users WHERE id=?";
		User user = null;

		try {

			Connection conn = new ConnectionDao().getConexao();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				id = rs.getInt("id");
				String fullName = rs.getString("fullName");
				Gender gender = Gender.valueOf(rs.getString("gender"));
				String email = rs.getString("email");
				Date birthDay = rs.getDate("birthDay");
				String cpf = rs.getString("cpf");
				String password = rs.getString("password");
				user = new User(id, fullName, gender, email, birthDay, cpf, password);
			}

			rs.close();
			pst.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;

	}

	public User loginUser(String email, String password) {
		String sql = "SELECT id, fullName, gender, email, birthDay, cpf, password FROM users WHERE email=?";
		User user = null;

		try (Connection conn = new ConnectionDao().getConexao(); PreparedStatement pst = conn.prepareStatement(sql)) {

			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
				String fullName = rs.getString("fullName");
				Gender gender = Gender.valueOf(rs.getString("gender"));
				String userEmail = rs.getString("email");
				Date birthDay = rs.getDate("birthDay");
				String cpf = rs.getString("cpf");
				String bdPassword = rs.getString("password");

				if (bdPassword.equals(password)) {
					user = new User(id, fullName, gender, userEmail, birthDay, cpf, bdPassword);
				}
			}

			rs.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return user;
	}

}
