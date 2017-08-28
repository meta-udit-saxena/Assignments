package com.metacube.priorityenum;

/**
 * The Enum Designation contains designation with their priorities level.
 */
public enum Designation {

	Undergraduate(1), graduate(2), professor(3), chairman(4);
	private int priority;

	/**
	 * Instantiates a new designation.
	 *
	 * @param priority
	 *            the priority
	 */
	Designation(int priority) {
		this.priority = priority;
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

}
