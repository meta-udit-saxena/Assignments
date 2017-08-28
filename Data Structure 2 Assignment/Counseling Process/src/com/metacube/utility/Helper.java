package com.metacube.utility;

import java.util.List;
import java.util.Scanner;
import com.metacube.entity.Candidate;
import com.metacube.entity.College;
import com.metacube.myqueue.MyQueue;

/**
 * The Class Helper for all input output operations.
 */
public class Helper {
	private Scanner scan;

	/**
	 * Instantiates a new helper.
	 */
	public Helper() {
		scan = new Scanner(System.in);
	}

	/**
	 * Gets the candidate choice in y or n format.
	 *
	 * @param candidateName
	 *            the candidate name
	 * @param collegeName
	 *            the college name
	 * @return the input either y (yes)or n (no)
	 */
	public String getInput(String candidateName, String collegeName) {
		System.out
				.println(candidateName + " do you want " + collegeName + " ?");
		String choice = scan.next();
		while (choice.equalsIgnoreCase("y") == false
				&& choice.equalsIgnoreCase("n") == false) {
			System.out.println("Enter correct option - y or n");
			choice = scan.next();
		}

		return choice;
	}

	/**
	 * Gets the number of counseling round.
	 *
	 * @return the total rounds
	 */
	public int getCounselingRound() {
		System.out.println("\nEnter total Counseling Round");
		int rounds;
		while (scan.hasNextInt() == false || (rounds = scan.nextInt()) < 1) {
			System.out.println("Enter Positive integer");
			scan.next();
		}

		return rounds;
	}

	/**
	 * Prints the candidate details.
	 *
	 * @param candidateList
	 *            the candidate list
	 */
	public void printCandidateDetails(List<Candidate> candidateList) {
		System.out
				.println("\n--------------------------------------Candidates List-------------------------------------------------");
		for (Candidate candidate : candidateList) {
			System.out.println(candidate);
		}
	}

	/**
	 * Prints the college details.
	 *
	 * @param collegeList
	 *            the college list
	 */
	public void printCollegeDetails(List<College> collegeList) {
		System.out
				.println("\n----------------------------------------College List-------------------------------------------------");
		for (College college : collegeList) {
			System.out.println(college);
		}
	}

	/**
	 * Prints the remaining students.
	 *
	 * @param queue
	 *            the candidates queue
	 */
	public void printRemainingStudents(MyQueue<Candidate> queue) {
		System.out.println(queue);
	}

	/**
	 * Prints the selected candidate.
	 *
	 * @param candidatesList
	 *            the candidates list
	 */
	public void printSelectedCandidate(List<Candidate> candidatesList) {
		for (Candidate candidate : candidatesList) {
			if (candidate.getCollege() != null) {
				System.out.println("Candidate " + candidate.getName() + " get "
						+ candidate.getCollege().getName() + " college");
			}
		}
	}

	/**
	 * Prints the counseling result.
	 *
	 * @param counsellingNumber
	 *            the counseling number
	 * @param candidatesList
	 *            the candidates list
	 * @param queue
	 *            the queue
	 */
	public void printCounsellingResult(int counselingNumber,
			List<Candidate> candidatesList, MyQueue<Candidate> queue) {
		System.out
				.println("\n************************************************** Round "
						+ counselingNumber
						+ " result *********************************************\n");
		System.out
				.println("------------------------------------------Selected Candidates--------------------------------------------------");
		printSelectedCandidate(candidatesList);
		System.out
				.println("-----------------------------------------Remaining Candidates--------------------------------------------------");
		printRemainingStudents(queue);
	}

	/**
	 * Prints the counseling header.
	 *
	 * @param round
	 *            the round
	 */
	public void printCounsellingHeader(int round) {
		System.out
				.println("\n************************************ Counseling Round "
						+ round
						+ " started***************************************************\n");
	}
}
