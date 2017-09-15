package com.metacube.facade;

import com.metacube.dao.BooksDao;
import com.metacube.dao.TitleDao;
import com.metacube.dto.OperationResult;
import com.metacube.dto.TitleListResponse;

/**
 * The Class LibraryFacade.
 */
public class LibraryFacade implements BaseFacade {
	private static LibraryFacade libraryFacade;

	/**
	 * Instantiates a new library facade.
	 */
	private LibraryFacade() {
	}

	/**
	 * Gets the single instance of LibraryFacade.
	 *
	 * @return single instance of LibraryFacade
	 */
	public static LibraryFacade getInstance() {
		if (libraryFacade == null) {
			synchronized (LibraryFacade.class) {
				if (libraryFacade == null) {
					libraryFacade = new LibraryFacade();
				}
			}
		}

		return libraryFacade;
	}

	/**
	 * Gets the titles list.
	 *
	 * @param authorName
	 *            the author name
	 * @return the title list
	 */
	public TitleListResponse getTitlesList(String authorName) {
		return TitleDao.getInstance().getTitlesPublishedByAuthor(authorName);
	}

	/**
	 * Checks if book is available.
	 *
	 * @param bookName
	 *            the book name
	 * @return the result - the operationResult DTO
	 */
	public OperationResult isBookAvailable(String bookName) {
		return BooksDao.getInstance().isBookAvailable(bookName);
	}

	/**
	 * Delete old unused books.
	 *
	 * @return the result - the operationResult DTO
	 */
	public OperationResult deleteOldUnissuedBooks() {
		return BooksDao.getInstance().deleteOldUnissuedBooks();
	}
}