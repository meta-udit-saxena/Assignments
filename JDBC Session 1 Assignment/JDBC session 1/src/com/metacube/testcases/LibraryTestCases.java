package com.metacube.testcases;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.management.openmbean.OpenDataException;

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
	public void GivenValidAuthorName_WhengetTitlesPublishedByAuthor_ThenTitleList() {
		String actual = controller.getTitlesPublishedByAuthor("J. K. Rowling");
		String expected = "\nList of title are following \n\n"
				+ "1 Harry Potter - Goblet of Fire\n" + "2 Earth Facts\n";
		assertEquals(actual, expected);
	}

	@Test
	public void GivenInValidAuthorName_WhengetTitlesPublishedByAuthor_ThenErrorMsg() {
		String actual = controller.getTitlesPublishedByAuthor("Udit Saxena");
		String expected = "No such Data Exist";
		assertEquals(expected, actual);
	}

	@Test
	public void GivenValidBookName_WhenisBookAvailable_ThenValidResponse() {
		OperationResult actual = controller.isBookAvailable("Let Us C");
		OperationResult expected = new OperationResult();
		expected.message = "This Book is Available";
		assertEquals(expected.message, actual.message);
		assertEquals(expected.success, actual.success);
	}

	@Test
	public void GivenInValidBookName_WhenisBookAvailable_ThenValidResponse() {
		OperationResult actual = controller.isBookAvailable("Wrangler");
		OperationResult expected = new OperationResult();
		expected.message = "This Book is Already Issue to Someone or Not available";
		assertEquals(expected.message, actual.message);
		assertEquals(expected.success, actual.success);
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
		OperationResult expected = new OperationResult();
		expected.message = "1 books deleted";
		assertEquals(expected.message, actual.message);
		assertEquals(expected.success, actual.success);
	}

	@Test
	public void GivenOldBooksNotExists_WhenDeleteOldUnissuedBooks_ThenValidResponse() {
		OperationResult actual = controller.deleteOldUnissuedBooks();
		OperationResult expected = new OperationResult();
		expected.message = "no such books found";
		assertEquals(expected.message, actual.message);
		assertEquals(expected.success, actual.success);
	}

}
