package com.metacube.testcases;

import static org.junit.Assert.assertEquals;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;
import com.metacube.controller.LibraryController;
import com.metacube.dto.OperationResult;
import com.metacube.factory.ConnectionFactory;

public class LibraryTestCases {

	private LibraryController controller;

	@Before
	public void setUpObject() {
		controller = new LibraryController();
	}

	@Test
	public void GivenValidAuthorName_WhenGetTitlesPublishedByAuthor_ThenTitleList() {
		String actual = controller.getTitlesPublishedByAuthor("J. K. Rowling");
		String expected = "\nList of title are following \n\n"
				+ "1 Harry Potter - Goblet of Fire\n" + "2 Earth Facts\n";
		assertEquals(expected, actual);
	}

	@Test
	public void GivenInValidAuthorName_WhenGetTitlesPublishedByAuthor_ThenErrorMsg() {
		String actual = controller.getTitlesPublishedByAuthor("Udit Saxena");
		assertEquals("No such Data Exist", actual);
	}

	@Test
	public void GivenNull_WhenGetTitlesPublishedByAuthor_ThenErrorMsg() {
		String actual = controller.getTitlesPublishedByAuthor(null);
		assertEquals("No such Data Exist", actual);
	}

	@Test
	public void GivenValidBookName_WhenIsBookAvailable_ThenValidResponse() {
		OperationResult actual = controller.isBookAvailable("Let Us C");
		assertEquals("This Book is Available", actual.message);
		assertEquals(true, actual.success);
	}

	@Test
	public void GivenInValidBookName_WhenIsBookAvailable_ThenValidResponse() {
		OperationResult actual = controller.isBookAvailable("Wrangler");
		assertEquals("This Book is Already Issue to Someone or Not available",
				actual.message);
		assertEquals(true, actual.success);
	}

	@Test
	public void GivenNull_WhenIsBookAvailable_ThenValidResponse() {
		OperationResult actual = controller.isBookAvailable(null);
		assertEquals("This Book is Already Issue to Someone or Not available",
				actual.message);
		assertEquals(true, actual.success);
	}

	@Test
	public void GivenOldBooksExists_WhenDeleteOldUnissuedBooks_ThenValidResponse()
			throws SQLException {
		ConnectionFactory
				.getConnection()
				.prepareStatement(
						"INSERT INTO `books`(accession_no, title_id, purchase_date, price, status) VALUES('Book5', 'Title5', '2015-03-13', 510.00, 'AVAILABLE')")
				.executeUpdate();
		OperationResult actual = controller.deleteOldUnissuedBooks();
		assertEquals("1 books deleted", actual.message);
		assertEquals(true, actual.success);
	}

	@Test
	public void GivenOldBooksNotExists_WhenDeleteOldUnissuedBooks_ThenValidResponse() {
		OperationResult actual = controller.deleteOldUnissuedBooks();
		assertEquals("no such books found", actual.message);
		assertEquals(true, actual.success);
	}
}