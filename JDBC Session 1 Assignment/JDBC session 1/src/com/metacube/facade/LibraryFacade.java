package com.metacube.facade;

import java.sql.SQLException;
import java.util.List;
import com.metacube.dao.BooksDao;
import com.metacube.dao.TitleDao;
import com.metacube.entity.Title;
import com.metacube.enums.Status;

/**
 * The Class LibraryFacade.
 */
public class LibraryFacade {

	/** The library facade. */
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
	 * Gets the title list.
	 *
	 * @param authorName the author name
	 * @return the title list
	 * @throws SQLException the SQL exception
	 */
	public String getTitleList(String authorName) throws SQLException {

		String titlesName = "\nList of title are following \n\n";
		try {
			List<Title> list = TitleDao.getInstance()
					.getTitlesPublishedByAuthor(authorName);
			if (list.size() == 0) {
				return "No such Data Exist";
			}
			int index = 1;
			for (Title t : list) {
				titlesName = titlesName.concat(index + " " + t.getTitleName())
						+ "\n";
				index++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return titlesName;
	}
	
	/**
	 * Checks if is book available.
	 *
	 * @param bookName the book name
	 * @return the status
	 */
	public Status isBookAvailable(String bookName){
		return BooksDao.getInstance().isAvailable(bookName);
	}
	
	/**
	 * Delete old unissued books.
	 *
	 * @return the string
	 */
	public String deleteOldUnissuedBooks(){
		return BooksDao.getInstance().deleteOldUnissuedBooks();
	}
}
