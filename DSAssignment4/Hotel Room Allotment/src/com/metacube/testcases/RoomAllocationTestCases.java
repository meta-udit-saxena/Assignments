/**
 * 
 */
package com.metacube.testcases;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.metacube.controller.RoomAllocation;
import com.metacube.entity.Guest;

/**
 * @author Udit Saxena
 *
 */
public class RoomAllocationTestCases {

	RoomAllocation roomAllocation;

	@Before
	public void setUpObject() {
		roomAllocation = new RoomAllocation(13);
	}

	@Test
	public void GivenAgeAndNameAreValidWhenAddGuestThenTrue() {
		boolean actual = roomAllocation.addGuest(22, "Udit");
		assertEquals(true, actual);
	}

	@Test
	public void GivenAgeAndNameAreNotValidWhenAddGuestThenFalse() {
		boolean actual = roomAllocation.addGuest(22, null);
		assertEquals(false, actual);
	}

	@Test
	public void GivenAgeAndNameAreValidWhenGetGuestThenGuestDetails() {
		roomAllocation.addGuest(22, "Udit");
		Guest actual = roomAllocation.getGuest(22, "Udit");
		int expectedAge = 22;
		int actualAge = actual.getAge();
		String expectedName = "Udit";
		String actualName = actual.getName();
		assertEquals(expectedAge, actualAge);
		assertEquals(expectedName, actualName);
	}

	@Test
	public void GivenAgeAndNameAreNotValidWhenGetGuestNull() {
		roomAllocation.addGuest(22, "Udit");
		Guest actual = roomAllocation.getGuest(22, "Udits");
		assertEquals(null, actual);
	}
}
