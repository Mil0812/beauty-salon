package com.mil0812.learnspring.persistence.dao;

import com.mil0812.learnspring.persistence.dao.Dao;
import com.mil0812.learnspring.persistence.entity.BeautyMaster;
import com.mil0812.learnspring.persistence.entity.Client;
import com.mil0812.learnspring.persistence.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BeautyMasterDao implements Dao<Integer, BeautyMaster> {

	@Override
	public boolean create(BeautyMaster beautyMaster) {
		String sql = "INSERT INTO beauty_master(client_id, salary, experience_year) VALUES (?, ?, ?)";
		try (Connection connection = ConnectionManager.getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, beautyMaster.getClient().getId());
			preparedStatement.setInt(2, beautyMaster.getSalary());
			preparedStatement.setInt(3, beautyMaster.getExperienceYear());

			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<BeautyMaster> getAll() {
		String sql = "SELECT * FROM beauty_master";
		List<BeautyMaster> beautyMasters = new ArrayList<>();
		try (Connection connection = ConnectionManager.getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int clientId = resultSet.getInt("client_id");
				int salary = resultSet.getInt("salary");
				int experienceYear = resultSet.getInt("experience_year");
				Client client = new Client(clientId, null, null, null);
				beautyMasters.add(new BeautyMaster(id, client, salary, experienceYear));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return beautyMasters;
	}

	@Override
	public BeautyMaster getById(Integer id) {
		String sql = "SELECT * FROM beauty_master WHERE id = ?";
		try (Connection connection = ConnectionManager.getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int clientId = resultSet.getInt("client_id");
				int salary = resultSet.getInt("salary");
				int experienceYear = resultSet.getInt("experience_year");
				Client client = new Client(clientId, null, null, null); // Створюємо пустий об'єкт клієнта, тут потрібно отримати реальні дані з бази даних
				return new BeautyMaster(id, client, salary, experienceYear);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BeautyMaster update(BeautyMaster beautyMaster) {
		String sql = "UPDATE beauty_master SET client_id = ?, salary = ?, experience_year = ? WHERE id = ?";
		try (Connection connection = ConnectionManager.getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, beautyMaster.getClient().getId());
			preparedStatement.setInt(2, beautyMaster.getSalary());
			preparedStatement.setInt(3, beautyMaster.getExperienceYear());
			preparedStatement.setInt(4, beautyMaster.getId());

			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				return beautyMaster;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		String sql = "DELETE FROM beauty_master WHERE id = ?";
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
