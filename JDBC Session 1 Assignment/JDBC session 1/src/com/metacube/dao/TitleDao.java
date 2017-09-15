package com.metacube.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.metacube.dto.TitleListResponse;
import com.metacube.entity.Title;
import com.metacube.factory.ConnectionFactory;
import com.metacube.utility.SQLQueries;

/**
 * The Class TitleDao.
 */
public class TitleDao implements BaseDao {
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
	public static TitleDao getInstance() {
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
	 */
	public TitleListResponse getTitlesPublishedByAuthor(String authorName) {
		TitleListResponse response = new TitleListResponse();
		try {
			List<Title> titleList = new ArrayList<Title>();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement(SQLQueries.getTitleListByAuthorNameQuery);
			preparedStatement.setString(1, authorName);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				titleList.add(new Title(rs.getString("title_id"), rs
						.getString("title_name")));
			}
			response.titlesList = titleList;
		} catch (SQLException se) {
			response.message = "Error occured due to " + se;
			response.success = false;
		}

		return response;
	}
}