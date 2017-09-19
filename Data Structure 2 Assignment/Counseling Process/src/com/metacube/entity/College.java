package com.metacube.entity;

/**
 * The Class College.
 */
public class College extends Entity {
	private int availableSeats;
	private int totalSeats;

	/**
	 * Instantiates a new college.
	 *
	 * @param details
	 *            the details
	 */
	public College(String details) {
		String[] collegeDetails = details.split(",");
		setId(collegeDetails[0]);
		setName(collegeDetails[1]);
		try {
			setRank(Integer.parseInt(collegeDetails[2]));
		} catch (NumberFormatException e) {
			setRank(0);
		}
		try {
			this.availableSeats = Integer.parseInt(collegeDetails[3]);
		} catch (NumberFormatException e) {
			this.availableSeats = 0;
		}
		this.totalSeats = this.availableSeats;
	}

	/**
	 * Gets the seats available.
	 *
	 * @return the seats available
	 */
	public int getSeatsAvailable() {
		return availableSeats;
	}

	/**
	 * Sets the seats available.
	 *
	 * @param seats
	 *            the new seats available
	 */
	public void setSeatsAvailable(int seats) {
		this.availableSeats = seats;
	}

	/**
	 * Gets the total seats.
	 *
	 * @return the totalSeats
	 */
	public int getTotalSeats() {
		return totalSeats;
	}

	/**
	 * Sets the total seats.
	 *
	 * @param totalSeats
	 *            the totalSeats to set
	 */
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	/**
	 * Override to string method to print College details
	 */
	@Override
	public String toString() {
		return "Id : " + getId() + "\tName : " + getName() + "\trank : "
				+ getRank() + "  Available seats : " + availableSeats + "/"
				+ totalSeats;
	}
}
