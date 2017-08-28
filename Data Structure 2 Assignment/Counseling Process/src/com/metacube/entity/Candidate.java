package com.metacube.entity;

/**
 * The Class Candidate store candidate informations
 */
public class Candidate extends Entity implements Comparable<Candidate> {
	private String[] optedColleges;
	private College college;

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
		setRank(Integer.parseInt(candidateDetails[2]));
		this.optedColleges = candidateDetails[3].split("/");
		this.setCollege(null);
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
	public College getCollege() {
		return college;
	}

	/**
	 * Sets the college.
	 *
	 * @param college
	 *            the new college
	 */
	public void setCollege(College college) {
		this.college = college;
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
