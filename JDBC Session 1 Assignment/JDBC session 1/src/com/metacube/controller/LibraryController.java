package com.metacube.controller;

import java.util.List;
import com.metacube.dao.TitleDao;
import com.metacube.dto.OperationResult;
import com.metacube.dto.TitleListResponse;
import com.metacube.entity.Title;
import com.metacube.facade.LibraryFacade;

/**
 * The Class Controller.
 */
public class LibraryController {

	/**
	 * Gets the titles published by author.
	 *
	 * @param authorName
	 *            the author name
	 * @return the titles published by author
	 */
	public String getTitlesPublishedByAuthor(String authorName) {
		TitleListResponse response = TitleDao.getInstance()
				.getTitlesPublishedByAuthor(authorName);
		if (response.success == true) {
			String message = "\nList of title are following \n\n";
			List<Title> list = response.titlesList;
			if (list.size() == 0) {
				message = "No such Data Exist";
			} else {
				int index = 1;
				for (Title t : list) {
					message = message.concat(index + " " + t.getTitleName())
							+ "\n";
					index++;
				}
			}

			return message;
		} else {

			return response.message;
		}
	}

	/**
	 * Checks if book is available.
	 *
	 * @param bookName
	 *            the book name
	 * @return the result - the operationResult response
	 */
	public OperationResult isBookAvailable(String bookName) {
		return LibraryFacade.getInstance().isBookAvailable(bookName);
	}

	/**
	 * Delete old unused books.
	 *
	 * @return the result - the operationResult response
	 */
	public OperationResult deleteOldUnissuedBooks() {
		return LibraryFacade.getInstance().deleteOldUnissuedBooks();
	}
}