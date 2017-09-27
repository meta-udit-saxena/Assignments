package com.metacube.get.layarch.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.metacube.get.layarch.model.Product;

public abstract class GenericJdbcDao<T, ID extends Serializable> implements
		AbstractDao<T, ID> {
	JdbcConnectionFactory connectionFactory = new JdbcConnectionFactory();

	protected abstract String getTableName();

	protected abstract T extractResultSetRow(ResultSet resultSet);

	protected abstract String getPrimaryKeyColoumnName();

	public <S extends T> S save(final S entity) {
		return null;
	}

	public T findOne( ID primaryKey) {
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM "
					+ getTableName() + " where " + getPrimaryKeyColoumnName()
					+ " = '" + primaryKey + "'");
			while (resultSet.next()) {
				return extractResultSetRow(resultSet);
			}
			return null;
		} catch (Exception e) {
			// TODO - Logging
			return null;
		}
	}

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
			// TODO - Logging
			return Collections.emptyList();
		}

	}

	public Long count() {
		return null;
	}

	public void delete(final T entity) {

	}

	public boolean exists(final ID primaryKey) {
		return false;
	}
}
