package com.metacube.dao;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.metacube.entity.Candidate;
import com.metacube.utility.FilePaths;

/**
 * The Class CandidateInMemoryDao stores the Candidates List.
 */
public class CandidateInMemoryDao {
	private List<Candidate> candidatesList;
	private static CandidateInMemoryDao candidateInMemoryDao;

	/**
	 * Instantiates a new candidate in memory dao.
	 */
	private CandidateInMemoryDao() {
		candidatesList = new ArrayList<Candidate>();
		initializeCandidateList();
	}

	/**
	 * Gets the single instance of CandidateInMemoryDao.
	 *
	 * @return single instance of CandidateInMemoryDao
	 */
	public static CandidateInMemoryDao getInstance() {
		if (candidateInMemoryDao == null) {
			synchronized (CandidateInMemoryDao.class) {
				if (candidateInMemoryDao == null) {
					candidateInMemoryDao = new CandidateInMemoryDao();
				}
			}
		}

		return candidateInMemoryDao;
	}

	/**
	 * Initialize candidate list.
	 */
	private void initializeCandidateList() {

		List<String> candidateDetails = new ArrayList<String>();
		try {
			candidateDetails = Files.readAllLines(Paths
					.get(FilePaths.CANDIDATESFILE_PATH));
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (String details : candidateDetails) {
			candidatesList.add(new Candidate(details));
		}
	}

	/**
	 * Gets the candidates list.
	 *
	 * @return the candidates list
	 */
	public List<Candidate> getCandidatesList() {
		return candidatesList;
	}

	/**
	 * Adds the candidate to list
	 *
	 * @param candidate
	 *            the candidate
	 */
	public void add(Candidate candidate) {
		candidatesList.add(candidate);
	}

	/**
	 * Removes the candidate from list
	 *
	 * @param candidate
	 *            the candidate
	 */
	public void remove(Candidate candidate) {
		candidatesList.remove(candidate);
	}

}
