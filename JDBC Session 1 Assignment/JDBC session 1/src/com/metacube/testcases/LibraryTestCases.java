package com.metacube.testcases;

import org.junit.Before;
import org.junit.Test;

import com.metacube.controller.LibraryController;
import com.metacube.dto.TitleListDTO;

public class LibraryTestCases {

	private LibraryController controller;
	
	@Before
	public void setUpObject(){
		controller = new LibraryController();
	}
	
	@Test
	public void GivenValidAuthorName_WhengetTitlesPublishedByAuthor_ThenTitleList(){
		TitleListDTO response = 
	}
}
