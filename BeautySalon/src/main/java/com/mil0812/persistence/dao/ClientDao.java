package com.mil0812.learnspring.persistence.dao;

import com.mil0812.learnspring.persistence.entity.Client;
import com.mil0812.learnspring.persistence.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDao implements Dao<Integer, Client> {

	@Override
	public boolean create(Client client) {
		String sql = "INSERT INTO client(full_name, phone_number, password) VALUES (?, ?, ?)";
		try (Connection connection = ConnectionManager.getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, client.getFullName());
			preparedStatement.setString(2, client.getPhoneNumber());
			preparedStatement.setString(3, client.getPassword());

			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Client> getAll() {
		String sql = "SELECT * FROM client";
		List<Client> clients = new ArrayList<>();
		try (Connection connection = ConnectionManager.getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String fullName = resultSet.getString("full_name");
				String phoneNumber = resultSet.getString("phone_number");
				String password = resultSet.getString("password");
				clients.add(new Client(id, fullName, phoneNumber, password));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}

	@Override
	public Client getById(Integer id) {
		String sql = "SELECT * FROM client WHERE id = ?";
		try (Connection connection = ConnectionManager.getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String fullName = resultSet.getString("full_name");
				String phoneNumber = resultSet.getString("phone_number");
				String password = resultSet.getString("password");
				return new Client(id, fullName, phoneNumber, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Client update(Client client) {
		String sql = "UPDATE client SET full_name = ?, phone_number = ?, password = ? WHERE id = ?";
		try (Connection connection = ConnectionManager.getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, client.getFullName());
			preparedStatement.setString(2, client.getPhoneNumber());
			preparedStatement.setString(3, client.getPassword());
			preparedStatement.setInt(4, client.getId());

			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				return client;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		String sql = "DELETE FROM client WHERE id = ?";
		try (Connection connection = ConnectionManager.getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, id);
			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
