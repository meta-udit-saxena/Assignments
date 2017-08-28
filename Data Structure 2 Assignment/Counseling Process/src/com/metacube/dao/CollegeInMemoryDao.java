package com.metacube.dao;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.metacube.entity.College;
import com.metacube.utility.FilePaths;

/**
 * The Class CollegeInMemoryDao stores Colleges List.
 */
public class CollegeInMemoryDao {

	private List<College> collegesList;
	private static CollegeInMemoryDao collegeInMemoryDao;

	/**
	 * Instantiates
	 */
	private CollegeInMemoryDao() {
		collegesList = new ArrayList<College>();
		initializeCollegeList();
	}

	/**
	 * Gets the single instance of CollegeInMemoryDao.
	 *
	 * @return single instance of CollegeInMemoryDao
	 */
	public static CollegeInMemoryDao getInstance() {
		if (collegeInMemoryDao == null) {
			synchronized (CollegeInMemoryDao.class) {
				if (collegeInMemoryDao == null) {
					collegeInMemoryDao = new CollegeInMemoryDao();
				}
			}
		}
		return collegeInMemoryDao;
	}

	/**
	 * Initialize the college list from college txt file
	 */
	private void initializeCollegeList() {
		List<String> collegesDetails = new ArrayList<String>();
		try {
			collegesDetails = Files.readAllLines(Paths
					.get(FilePaths.COLLEGESFILE_PATH));
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (String details : collegesDetails) {
			collegesList.add(new College(details));
		}
	}

	/**
	 * Gets the colleges list.
	 *
	 * @return the colleges list
	 */
	public List<College> getCollegesList() {
		return collegesList;
	}

	/**
	 * Adds the college to college List;
	 *
	 * @param college
	 *            the college
	 */
	public void add(College college) {
		collegesList.add(college);
	}

	/**
	 * Removes the college from list
	 *
	 * @param college
	 *            the college
	 */
	public void remove(College college) {
		collegesList.remove(college);
	}

	/**
	 * Gets the college by id.
	 *
	 * @param id
	 *            the college id
	 * @return the college if present else null
	 */
	public College getCollegeById(String id) {
		for (College college : collegesList) {
			if (college.getId() == id) {
				return college;
			}
		}
		return null;
	}

	/**
	 * Update college.
	 *
	 * @param college
	 *            the college class object
	 */
	public void updateCollege(College college) {
		College obj = getCollegeById(college.getId());
		obj.setSeatsAvailable(college.getSeatsAvailable());
	}
}
