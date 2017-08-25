package com.metacube.jobprinting;

/**
 * The Class Task.
 */
public class Task implements Comparable {

	/** The designation. */
	private String designation;

	/** The priority. */
	private int priority;

	/** The messsage. */
	private String messsage;

	/**
	 * Gets the messsage.
	 *
	 * @return the messsage
	 */
	public Task(){
		
	}
	
	public Task(String designation, int priority, String messsage) {
		this.designation = designation;
		this.priority = priority;
		this.messsage = messsage;
	}

	public String getMesssage() {
		return messsage;
	}

	/**
	 * Sets the messsage.
	 *
	 * @param messsage
	 *            the new messsage
	 */
	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}

	/**
	 * Gets the designation.
	 *
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * Sets the designation.
	 *
	 * @param designation
	 *            the new designation
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * Gets the priority.
	 *
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Sets the priority.
	 *
	 * @param priority
	 *            the new priority
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/*
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Object arg0) {
		int priority1 = this.priority;
		int answer = 0;
		Task t = (Task) arg0;
		int priority2 = t.priority;
		if (priority1 < priority2) {
			answer = 1;
		} else if (priority1 > priority2) {
			answer = -1;
		}
		return answer;
	}

}
