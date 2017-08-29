package com.metacube.facade;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.metacube.controller.Controller;
import com.metacube.dao.CandidateInMemoryDao;
import com.metacube.dao.CollegeInMemoryDao;
import com.metacube.entity.Candidate;
import com.metacube.entity.College;
import com.metacube.myqueue.MyQueue;

/**
 * The Class CounselingFacade perform counseling operations.
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
	 * Gets the college capacity map.
	 *
	 * @return the college capacity map between college id and capacity
	 */
	private Map<String, Integer> getCollegeCapacityMap() {
		Map<String, Integer> capacityMap = new HashMap<String, Integer>();
		List<College> collegeList = CollegeInMemoryDao.getInstance()
				.getCollegesList();
		for (College college : collegeList) {
			capacityMap.put(college.getId(), college.getSeatsAvailable());
		}

		return capacityMap;
	}

	/**
	 * Start counseling.
	 */
	public void startCounseling() {
		CollegeInMemoryDao collegeDao = CollegeInMemoryDao.getInstance();
		Map<String, Integer> collegeMap = getCollegeCapacityMap();
		String choice;
		boolean skip;
		boolean seatAlloted;
		int count = candidateQueue.size();
		// condition for total candidates each counseling round run for
		// exact one time for each candidate
		while (count != 0) {
			seatAlloted = false;
			skip = false;
			Candidate candidate = (Candidate) candidateQueue.dequeue();
			String[] candidateChoice = candidate.getOptedColleges();
			// go through each choice
			for (int index = 0; index < candidateChoice.length; index++) {
				// check for the college is seat available or not
				// if available then
				if (collegeMap.get(candidateChoice[index]) != 0) {
					choice = Controller.getInstance().getInput(
							candidate.getName(),
							collegeDao.getCollegeById(candidateChoice[index])
									.getName());
					if (choice.equalsIgnoreCase("y")) {
						candidate.setCollegeId(candidateChoice[index]);
						collegeDao
								.getCollegeById(candidateChoice[index])
								.setSeatsAvailable(
										collegeMap.get(candidateChoice[index]) - 1);
						seatAlloted = true;
						skip = false;
					} else {
						skip = true;
						// if candidate reject first choice then he not eligible
						// for next round
						if (index == 0) {
							seatAlloted = true;
						}
					}
					collegeMap.put(candidateChoice[index],
							collegeMap.get(candidateChoice[index]) - 1);
					break;
				}
			}

			// if college is not alloted to candidate it goes to queue again
			if (seatAlloted == false) {
				candidateQueue.enqueue(candidate);
			}
			count--;
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

	/**
	 * Gets the colleges list.
	 *
	 * @return the colleges list
	 */
	public List<College> getCollegesList() {
		return CollegeInMemoryDao.getInstance().getCollegesList();
	}

	/**
	 * Gets the college name by id.
	 *
	 * @param collegeId
	 *            the college id
	 * @return the college name by id
	 */
	public String getCollegeNameById(String collegeId) {
		return CollegeInMemoryDao.getInstance().getCollegeById(collegeId)
				.getName();
	}
}
