package com.mil0812.learnspring.persistence.dao;

import com.mil0812.learnspring.persistence.dao.Dao;
import com.mil0812.learnspring.persistence.entity.AssistanceType;
import com.mil0812.learnspring.persistence.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssistanceTypeDao implements Dao<Integer, AssistanceType>{

	@Override
	public boolean create(AssistanceType assistanceType) {
		String sql = "INSERT INTO assistance_type(name, description, salary) VALUES (?, ?, ?)";
		try (Connection connection = ConnectionManager.getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, assistanceType.getName());
			preparedStatement.setString(2, assistanceType.getDescription());
			preparedStatement.setInt(3, assistanceType.getSalary());

			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<AssistanceType> getAll() {
		String sql = "SELECT * FROM assistance_type";
		List<AssistanceType> assistanceTypes = new ArrayList<>();
		try (Connection connection = ConnectionManager.getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				int salary = resultSet.getInt("salary");
				assistanceTypes.add(new AssistanceType(id, name, description, salary));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return assistanceTypes;
	}

	@Override
	public AssistanceType getById(Integer id) {
		String sql = "SELECT * FROM assistance_type WHERE id = ?";
		try (Connection connection = ConnectionManager.getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				int salary = resultSet.getInt("salary");
				return new AssistanceType(id, name, description, salary);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AssistanceType update(AssistanceType assistanceType) {
		String sql = "UPDATE assistance_type SET name = ?, description = ?, salary = ? WHERE id = ?";
		try (Connection connection = ConnectionManager.getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, assistanceType.getName());
			preparedStatement.setString(2, assistanceType.getDescription());
			preparedStatement.setInt(3, assistanceType.getSalary());
			preparedStatement.setInt(4, assistanceType.getId());

			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				return assistanceType;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		String sql = "DELETE FROM assistance_type WHERE id = ?";
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
