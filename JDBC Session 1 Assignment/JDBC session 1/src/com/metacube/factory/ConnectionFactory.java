package com.metacube.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.metacube.utility.Constant;

/**
 * A factory for creating Connection objects.
 */
public class ConnectionFactory {

	/**
	 * Instantiates a new connection factory.
	 */
	private ConnectionFactory() {
	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		}
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 * @throws SQLException
	 *             the SQL exception
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(Constant.MYSQL_URL,
				Constant.USER_ID, Constant.PASSWORD);
	}

	/**
	 * Close connection.
	 *
	 * @param con
	 *            the connection
	 * @param stmt
	 *            the statement
	 * @param rs
	 *            the result set
	 * @throws Exception
	 *             the exception
	 */
	public static void closeConnection(Connection con,
			PreparedStatement preparedStatement, ResultSet rs) {
		try {
			if (con != null) {

				con.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}