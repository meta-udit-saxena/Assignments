package com.metacube.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.metacube.entity.Title;
import com.metacube.factory.ConnectionFactory;

/**
 * The Class TitleDao.
 */
public class TitleDao {

	/** The title dao. */
	private static TitleDao titleDao;

	/**
	 * Instantiates a new title dao.
	 */
	private TitleDao() {
	}

	/**
	 * Gets the single instance of TitleDao.
	 *
	 * @return single instance of TitleDao
	 * @throws SQLException
	 *             the SQL exception
	 */
	public static TitleDao getInstance() throws SQLException {
		if (titleDao == null) {
			synchronized (TitleDao.class) {
				if (titleDao == null) {
					titleDao = new TitleDao();
				}
			}
		}
		return titleDao;
	}

	/**
	 * Gets the titles published by author.
	 *
	 * @param authorName
	 *            the author name
	 * @return the titles published by author
	 * @throws SQLException
	 *             the SQL exception
	 */
	public List<Title> getTitlesPublishedByAuthor(String authorName)
			throws SQLException {
		List<Title> titleList = new ArrayList<Title>();
		Connection con = ConnectionFactory.getConnection();
		String query = "SELECT t.title_id, " + "t.title_name "
				+ "FROM title t " + "INNER JOIN Title_author ta "
				+ "ON (t.title_id=ta.title_id) " + "INNER JOIN author a "
				+ "ON(a.author_id = ta.author_id) " + "WHERE a.author_name = ?";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, authorName);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			titleList.add(new Title(rs.getString("title_id"), rs
					.getString("title_name")));
		}

		return titleList;
	}
}
