package com.metacube.utility;

/**
 * The Class Queries.
 */
public class Queries {
	
	/**
	 * Given the name of the book, to be issued by an existing member.Return
	 * flag to indicate whether the the book has been issued or not.
	 */
	public static final String checkBookAvailableQuery = "SELECT * FROM "
													+ "books b "
													+ "INNER JOIN title t "
													+ "ON (b.title_id=t.title_id) "
													+ "WHERE "
													+ "t.title_name=? AND b.status = ?";
	
	/**
	 * This query Delete all those books which were not issued in last 1 year.
	 * Return the number of books deleted.
	 */
	public static final String deleteOldBooksQuery = "DELETE FROM books"
												+ " WHERE status <> 'unavaliable'"
												+ " AND "
												+ " accession_no "
												+ " NOT IN "
												+ "(SELECT"
												+ " accession_no "
												+ "	FROM  book_issue "
												+ "	WHERE "
												+ "	TIMESTAMPDIFF(year, issue_date, now()) < 1);";
	
	/**
	 * This query Fetch all the books published by author, given the name of the author.
	 * Return the books data (List of Titles)
	 */
	public static final String getTitleListByAuthorNameQuery ="SELECT t.title_id,"
																+ "t.title_name "
																+ "FROM title t " 
																+ "INNER JOIN Title_author ta "
																+ "ON (t.title_id=ta.title_id) "
																+ "INNER JOIN author a "
																+ "ON(a.author_id = ta.author_id) "
																+ "WHERE a.author_name = ?"; 
}
