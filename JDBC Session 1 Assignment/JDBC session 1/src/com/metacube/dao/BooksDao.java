package com.metacube.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.metacube.enums.Status;
import com.metacube.factory.ConnectionFactory;

/**
 * The Class BooksDao.
 */
public class BooksDao {

	/** The books dao. */
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
	 * Checks if is available.
	 *
	 * @param bookName the book name
	 * @return the status
	 */
	public Status isAvailable(String bookName){
		try{
			Connection con = ConnectionFactory.getConnection();
			String query = "SELECT * FROM books b INNER JOIN title t ON (b.title_id=t.title_id) WHERE t.title_name=? AND b.status = ?";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1,bookName);
			preparedStatement.setString(2,Status.AVAILABLE.toString());
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()){
				return Status.AVAILABLE;
			}else{
				return Status.UNAVAILABLE;
			}
		}catch(SQLException se){
			se.printStackTrace();
			System.out.println(se);
			return Status.FAILED;
		}
	}
	
	/**
	 * Delete old unissued books.
	 *
	 * @return the string
	 */
	public String deleteOldUnissuedBooks(){
		try{
			Connection con = ConnectionFactory.getConnection();
			String query = "DELETE FROM books"
					+ " WHERE status <> 'unavaliable'"
					+ " AND "
					+ " accession_no NOT IN "
					+ "(SELECT "
					+ "accession_no FROM  book_issue WHERE TIMESTAMPDIFF(year, issue_date, now()) < 1);";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			int rs = preparedStatement.executeUpdate();
			if(rs>0){
				return rs+" books deleted";
			}else{
				return "no such books found";
			}
		}catch(SQLException se){
			return Status.FAILED.toString();
		}
	}
}
