package com.metacube.controller;

import java.sql.SQLException;
import com.metacube.enums.Status;
import com.metacube.facade.LibraryFacade;

/**
 * The Class Controller.
 */
public class Controller {

	/**
	 * Gets the titles published by author.
	 *
	 * @param authorName the author name
	 * @return the titles published by author
	 */
	public String getTitlesPublishedByAuthor(String authorName) {
		try {
			return LibraryFacade.getInstance().getTitleList(authorName);
		} catch (SQLException se) {
			return "Failed";
		}
	}

	/**
	 * Checks if is book available.
	 *
	 * @param bookName the book name
	 * @return the status
	 */
	public Status isBookAvailable(String bookName)
	{
		return LibraryFacade.getInstance().isBookAvailable(bookName);
	}
	
	/**
	 * Delete old unissued books.
	 *
	 * @return the string
	 */
	public String deleteOldUnissuedBooks(){
		return LibraryFacade.getInstance().deleteOldUnissuedBooks();
	}
}
