package com.metacube.controller;

import com.metacube.facade.CounselingFacade;
import com.metacube.main.View;

/**
 * The Class Controller controls the counseling facade.
 */
public class Controller {
	private CounselingFacade counselingFacade;
	private static Controller controller;

	/**
	 * Instantiates a new controller.
	 */
	private Controller() {
		counselingFacade = CounselingFacade.getInstance();
	}

	/**
	 * Gets the single instance of Controller.
	 *
	 * @return single instance of Controller
	 */
	public static Controller getInstance() {
		if (controller == null) {
			synchronized (Controller.class) {
				if (controller == null) {
					controller = new Controller();
				}
			}
		}

		return controller;
	}

	/**
	 * Start counseling process.
	 */
	public void startCounseling() {
		View view = View.getInstance();
		view.printCandidateDetails(counselingFacade.getCandidateList());
		view.printCollegeDetails(counselingFacade.getCollegesList());
		int totalRound = view.getCounselingRound();
		int round = 1;
		while (round <= totalRound) {
			view.printCounsellingHeader(round);
			counselingFacade.startCounseling();
			view.printCounsellingResult(round,
					counselingFacade.getCandidateList(),
					counselingFacade.getCandidateQueue());
			round++;
		}
	}

	/**
	 * Gets the input.
	 *
	 * @param candidateName
	 *            the candidate name
	 * @param collegeName
	 *            the college name
	 * @return the input
	 */
	public String getInput(String candidateName, String collegeName) {
		return View.getInstance().getInput(candidateName, collegeName);
	}

	/**
	 * Gets the college name.
	 *
	 * @param collegeId
	 *            the college id
	 * @return the college name
	 */
	public String getCollegeName(String collegeId) {
		return CounselingFacade.getInstance().getCollegeNameById(collegeId);
	}
}
