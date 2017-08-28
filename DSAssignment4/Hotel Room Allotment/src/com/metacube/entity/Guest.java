package com.metacube.entity;

/**
 * The Class Guest contains guest details.
 */
public class Guest {
	String name;
	int age, roomNumber;

	/**
	 * Instantiates a new guest.
	 *
	 * @param name
	 *            the guest name
	 * @param age
	 *            the guest age
	 */
	public Guest(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * Gets the guest name.
	 *
	 * @return the guest name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the guest name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the Guest age.
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the Guest age.
	 *
	 * @param age
	 *            the new age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Gets the Guest room number.
	 *
	 * @return the room number
	 */
	public int getRoomNumber() {
		return roomNumber;
	}

	/**
	 * Sets the Guest room number.
	 *
	 * @param room
	 *            the new room number
	 */
	public void setRoomNumber(int room) {
		this.roomNumber = room;
	}

	/**
	 * Print Guest details
	 */
	@Override
	public String toString() {
		return "\nName : " + this.getName() + "\tAge : " + this.getAge()
				+ "\tRoomNo. : " + this.getRoomNumber();
	}
}
