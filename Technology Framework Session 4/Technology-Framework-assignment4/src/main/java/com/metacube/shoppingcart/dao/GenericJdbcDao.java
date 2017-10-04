package com.metacube.shoppingcart.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.model.Product;

/**
 * The Class GenericJdbcDao.
 *
 * @param <T>
 *            the generic type
 * @param <ID>
 *            the generic type
 */
public abstract class GenericJdbcDao<T, ID extends Serializable> implements
		AbstractDao<T, ID> {

	/** The connection factory. */
	JdbcConnectionFactory connectionFactory = new JdbcConnectionFactory();

	/**
	 * Gets the table name.
	 *
	 * @return the table name
	 */
	protected abstract String getTableName();

	/**
	 * Extract result set row.
	 *
	 * @param resultSet
	 *            the result set
	 * @return the t
	 */
	protected abstract T extractResultSetRow(ResultSet resultSet);

	/**
	 * Gets the primary key column name.
	 *
	 * @return the primary key column name
	 */
	protected abstract String getPrimaryKeyColoumnName();

	/**
	 * Save.
	 *
	 * @param <S>
	 *            the generic type
	 * @param entity
	 *            the entity
	 * @return the s
	 */
	public <S extends T> S save(final S entity) {
		return null;
	}

	/**
	 * Find one.
	 *
	 * @param primaryKey
	 *            the primary key
	 * @return the t
	 */
	public T findOne(ID primaryKey) {
		try {
			Connection connection = connectionFactory.getConnection();
			String query = "SELECT * FROM " + getTableName() + " where "
					+ getPrimaryKeyColoumnName() + " = ?";
			PreparedStatement preparedStatement = connection
					.prepareStatement(query);
			preparedStatement.setInt(1, (int) primaryKey);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				return extractResultSetRow(resultSet);
			}
			connection.close();
			return null;
		} catch (Exception e) {
			// TODO - Logging
			return null;
		}
	}

	/**
	 * Return complete list of product.
	 *
	 * @return the iterable
	 */
	public Iterable<T> findAll() {
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM "
					+ getTableName());
			List<T> userList = new ArrayList<>();
			while (resultSet.next()) {
				userList.add(extractResultSetRow(resultSet));
			}

			return userList;
		} catch (Exception e) {
			System.out.println(e);
			return Collections.emptyList();
		}
	}

	/**
	 * Return dashboard list of product.
	 *
	 * @return the iterable
	 */
	public Iterable<T> findDashboard() {
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM "
					+ getTableName() + " limit 8");
			List<T> userList = new ArrayList<>();
			while (resultSet.next()) {
				userList.add(extractResultSetRow(resultSet));
			}

			return userList;
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}

	/**
	 * Delete Product.
	 *
	 * @param id
	 *            the id
	 * @return the status
	 */
	public Status delete(int id) {
		try {
			Connection connection = connectionFactory.getConnection();
			String query = "DELETE FROM " + getTableName() + " where id = ?";
			PreparedStatement preparedStatement = connection
					.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int resultSet = preparedStatement.executeUpdate();
			if (resultSet > 0) {
				return Status.Success;
			} else {
				return Status.NOT_Found;
			}
		} catch (Exception e) {
			return Status.Error_Occured;
		}
	}

	/**
	 * Adds the.
	 *
	 * @param <S>
	 *            the generic type
	 * @param entity
	 *            the entity
	 * @return the status
	 */
	public <S extends T> Status add(S entity) {
		Status result = Status.Success;
		Product product = (Product) entity;
		try {
			Connection connection = connectionFactory.getConnection();
			String query = "INSERT INTO "
					+ getTableName()
					+ " (name,price,imagePath,description,currency)values (?,?,?,?,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(query);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setDouble(2, product.getPrice());
			preparedStatement.setString(3, product.getImagePath());
			preparedStatement.setString(4, product.getDescription());
			preparedStatement.setString(5, product.getCurrency());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			result = Status.Error_Occured;
		}

		return result;
	}

	/**
	 * Update product.
	 *
	 * @param <S>
	 *            the generic type
	 * @param entity
	 *            the entity
	 * @param id
	 *            the id
	 * @return the status
	 */
	public <S extends T> Status updateProduct(S entity, int id) {
		Status result = Status.Success;
		Product product = (Product) entity;
		try {
			Connection connection = connectionFactory.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE "
							+ getTableName()
							+ " SET name = ?,price=?,imagePath=?,description=?,currency=? WHERE "
							+ getPrimaryKeyColoumnName() + " = ?");
			preparedStatement.setString(1, product.getName());
			preparedStatement.setDouble(2, product.getPrice());
			preparedStatement.setString(3, product.getImagePath());
			preparedStatement.setString(4, product.getDescription());
			preparedStatement.setString(5, product.getCurrency());
			preparedStatement.setInt(6, id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			result = Status.Error_Occured;
		}

		return result;
	}
}
