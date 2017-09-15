package com.metacube.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.metacube.dto.OperationResult;
import com.metacube.factory.ConnectionFactory;
import com.metacube.utility.SQLQueries;

/**
 * The Class BooksDao.
 */
public class BooksDao implements BaseDao {

	private static BooksDao booksDao;

	/**
	 * Instantiates a new books dao.
	 */
	private BooksDao() {
	}

	/**
	 * Gets the single instance of BooksDao.
	 *
	 * @return single instance of BooksDao
	 */
	public static BooksDao getInstance() {
		if (booksDao == null) {
			synchronized (BooksDao.class) {
				if (booksDao == null) {
					booksDao = new BooksDao();
				}
			}
		}

		return booksDao;
	}

	/**
	 * Checks if book is available.
	 *
	 * @param bookName
	 *            the book name
	 * @return the result - the operationResult DTO
	 */
	public OperationResult isBookAvailable(String bookName) {
		OperationResult result = new OperationResult();
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement(SQLQueries.checkBookAvailableQuery);
			preparedStatement.setString(1, bookName);
			preparedStatement.setString(2, "Available");
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				result.message = "This Book is Available";
			} else {
				result.message = "This Book is Already Issue to Someone or Not available";
			}
		} catch (SQLException se) {
			result.success = false;
			result.message = "Error Occured due to " + se.getMessage();
		}

		return result;
	}

	/**
	 * Delete old unused books.
	 *
	 * @return the result - the operationResult DTO
	 */
	public OperationResult deleteOldUnissuedBooks() {
		OperationResult result = new OperationResult();
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement(SQLQueries.deleteOldBooksQuery);
			int rs = preparedStatement.executeUpdate();
			if (rs > 0) {
				result.message = rs + " books deleted";
			} else {
				result.message = "no such books found";
			}
		} catch (SQLException se) {
			result.message = "Error occured due to " + se;
			result.success = false;
		}

		return result;
	}
}