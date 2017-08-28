package com.metacube.facade;

import java.util.Collections;
import java.util.List;
import com.metacube.dao.CandidateInMemoryDao;
import com.metacube.dao.CollegeInMemoryDao;
import com.metacube.entity.Candidate;
import com.metacube.entity.College;
import com.metacube.myqueue.MyQueue;
import com.metacube.utility.Helper;

/**
 * The Class CounselingFacade perform counseling operations
 */
public class CounselingFacade {
	private MyQueue<Candidate> candidateQueue;
	private static CounselingFacade counselingFacade;
	private List<Candidate> candidateList;

	/**
	 * Instantiates a new counseling facade.
	 */
	private CounselingFacade() {
		initializeCandidateQueue();
	}

	/**
	 * Gets the single instance of CounselingFacade.
	 *
	 * @return single instance of CounselingFacade
	 */
	public static CounselingFacade getInstance() {
		if (counselingFacade == null) {
			synchronized (CounselingFacade.class) {
				if (counselingFacade == null) {
					counselingFacade = new CounselingFacade();
				}
			}
		}

		return counselingFacade;
	}

	/**
	 * Initialize candidate queue.
	 */
	private void initializeCandidateQueue() {
		candidateQueue = new MyQueue<Candidate>();
		candidateList = CandidateInMemoryDao.getInstance().getCandidatesList();
		Collections.sort(candidateList);
		for (Candidate candidate : candidateList) {
			candidateQueue.enqueue(candidate);
		}
	}

	/**
	 * Start counseling.
	 */
	public void startCounseling() {
		Helper helper = new Helper();
		CollegeInMemoryDao collegeDao = CollegeInMemoryDao.getInstance();
		List<College> collegesList = collegeDao.getCollegesList();
		String choice;
		boolean seatAlloted;
		// print candidate details
		helper.printCandidateDetails(candidateList);
		// print college details
		helper.printCollegeDetails(collegesList);
		int counclingRound = helper.getCounselingRound();
		int round = 1;
		// conditions for total counseling rounds
		while (round <= counclingRound) {
			helper.printCounsellingHeader(round);
			int count = candidateQueue.size();
			// condition for total candidates each counseling round run for
			// exact one time for each candidate
			while (count != 0) {
				seatAlloted = false;
				boolean skip = false;
				Candidate candidate = (Candidate) candidateQueue.dequeue();
				String[] candidateChoice = candidate.getOptedColleges();
				// go through each choice
				for (int index = 0; index < candidateChoice.length; index++) {
					for (College college : collegesList) {
						// if college seats are available and candidate choice
						// match with college id
						if (college.getSeatsAvailable() != 0
								&& college.getId().equals(
										candidateChoice[index])) {
							choice = helper.getInput(candidate.getName(),
									college.getName());
							if (choice.equalsIgnoreCase("y")) {
								college.setSeatsAvailable(college
										.getSeatsAvailable() - 1);
								collegeDao.updateCollege(college);
								candidate.setCollege(college);
								seatAlloted = true;
								skip = false;
							} else {
								skip = true;
							}
							break;
						}
					}
					// if candidate either select college or skip the college to
					// go to next round
					if (seatAlloted || skip) {
						break;
					}
				}
				// if college is not alloted to candidate it goes to queue again
				if (seatAlloted == false) {
					candidateQueue.enqueue(candidate);
				}
				count--;
			}
			// print the counseling result after each round
			helper.printCounsellingResult(round, candidateList, candidateQueue);
			round++;
		}
	}

	/**
	 * Gets the candidate queue.
	 *
	 * @return the candidate queue
	 */
	public MyQueue<Candidate> getCandidateQueue() {
		return candidateQueue;
	}

	/**
	 * Gets the candidate list.
	 *
	 * @return the candidate list
	 */
	public List<Candidate> getCandidateList() {
		return candidateList;
	}
}
