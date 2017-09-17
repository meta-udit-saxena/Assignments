package com.metacube.facade;

import com.metacube.dto.OperationResult;
import com.metacube.dto.TitleListResponse;

/**
 * The Interface BaseFacade.
 *
 * @param <E>
 *            the element type
 */
public interface BaseFacade {
	/**
	 * Gets the titles list.
	 *
	 * @param authorName
	 *            the author name
	 * @return the title list
	 */
	public TitleListResponse getTitlesList(String authorName);

	/**
	 * Checks if book is available.
	 *
	 * @param bookName
	 *            the book name
	 * @return the result - the operationResult response
	 */
	public OperationResult isBookAvailable(String bookName);

	/**
	 * Delete old unused books.
	 *
	 * @return the result - the operationResult response
	 */
	public OperationResult deleteOldUnissuedBooks();
}