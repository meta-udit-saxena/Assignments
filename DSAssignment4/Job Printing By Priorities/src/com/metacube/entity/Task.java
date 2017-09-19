package com.metacube.entity;

import com.metacube.priorityenum.Designation;

/**
 * The Class Task.
 */
public class Task implements Comparable<Task> {
	private Designation designation;
	private String jobToPrint;

	/**
	 * Instantiates a new task.
	 *
	 * @param designation
	 *            the designation
	 * @param jobToPrint
	 *            the job to print
	 */
	public Task(Designation designation, String jobToPrint) {
		this.setDesignation(designation);
		this.setJobToPrint(jobToPrint);
	}

	/**
	 * Gets the designation.
	 *
	 * @return the designation
	 */
	public Designation getDesignation() {
		return designation;
	}

	/**
	 * Sets the designation.
	 *
	 * @param designation
	 *            the new designation
	 */
	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	/**
	 * Gets the job to print.
	 *
	 * @return the job to print
	 */
	public String getJobToPrint() {
		return jobToPrint;
	}

	/**
	 * Sets the job to print.
	 *
	 * @param jobToPrint
	 *            the new job to print
	 */
	public void setJobToPrint(String jobToPrint) {
		this.jobToPrint = jobToPrint;
	}

	/**
	 * Comparison is Based on priority level
	 */
	@Override
	public int compareTo(Task obj) {
		return this.getDesignation().getPriority()
				- obj.getDesignation().getPriority();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((designation == null) ? 0 : designation.hashCode());
		result = prime * result
				+ ((jobToPrint == null) ? 0 : jobToPrint.hashCode());
		return result;
	}

	/**
	 * Override equals to check both object are same or not
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Task)) {
			return false;
		}
		Task other = (Task) obj;
		if (designation != other.designation) {
			return false;
		}
		if (jobToPrint == null) {
			if (other.jobToPrint != null) {
				return false;
			}
		} else if (!jobToPrint.equals(other.jobToPrint)) {
			return false;
		}
		return true;
	}
	

}
