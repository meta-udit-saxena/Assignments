package com.metacube.entity;

/**
 * The Class Candidate store candidate informations
 */
public class Candidate extends Entity implements Comparable<Candidate> {
	private String[] optedColleges;
	private String collegeId;

	/**
	 * Instantiates a new candidate.
	 *
	 * @param details
	 *            the details
	 */
	public Candidate(String details) {
		String[] candidateDetails = details.split(",");
		setId(candidateDetails[0]);
		setName(candidateDetails[1]);
		try {
			setRank(Integer.parseInt(candidateDetails[2]));
		} catch (NumberFormatException e) {
			setRank(0);
		}
		this.optedColleges = candidateDetails[3].split("/");
	}

	/**
	 * Gets the opted colleges.
	 *
	 * @return the opted colleges
	 */
	public String[] getOptedColleges() {
		return optedColleges;
	}

	/**
	 * Sets the opted colleges.
	 *
	 * @param choice
	 *            the new opted colleges
	 */
	public void setOptedColleges(String[] choice) {
		this.optedColleges = choice;
	}

	/**
	 * Gets the college.
	 *
	 * @return the college
	 */
	public String getCollegeId() {
		return collegeId;
	}

	/**
	 * Sets the college Id.
	 *
	 * @param collegeId
	 *            the new college
	 */
	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}

	/**
	 * Overriding the compare to function . Comparison based on candidate's rank
	 */
	@Override
	public int compareTo(Candidate obj) {
		return this.getRank() - ((Candidate) obj).getRank();
	}

	/**
	 * Overrides the to string method to print candidate object
	 */
	@Override
	public String toString() {
		String display = "Id : " + getId() + "\tName : " + getName()
				+ "\trank : " + getRank() + "  choice : [";
		for (int i = 0; i < optedColleges.length - 1; i++) {
			display += optedColleges[i] + " ";
		}
		display += optedColleges[optedColleges.length - 1] + "]";

		return display;
	}
}
