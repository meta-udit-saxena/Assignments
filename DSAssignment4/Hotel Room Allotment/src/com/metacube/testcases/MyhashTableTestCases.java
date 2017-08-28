package com.metacube.testcases;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.metacube.hashtable.MyHashTable;

public class MyhashTableTestCases {
	MyHashTable<Integer, String> hashTable;

	@Before
	public void setUpObject() {
		hashTable = new MyHashTable<Integer, String>(7);
	}

	@Test
	public void GivenKeyAndValueAreValidWhenInsertValueThenTrue() {
		boolean actual = hashTable.insertValue(10, "udit");
		assertEquals(true, actual);
	}

	@Test
	public void GivenKeyAndValueAreNotValidWhenInsertValueThenFalse() {
		boolean actual = hashTable.insertValue(10, null);
		assertEquals(false, actual);
	}

	@Test
	public void GivenKeyAndValueAreValidButExceedsLimitWhenInsertValueThenFalse() {
		hashTable.insertValue(10, "udit1");
		hashTable.insertValue(11, "udit2");
		hashTable.insertValue(12, "udit3");
		hashTable.insertValue(13, "udit4");
		hashTable.insertValue(14, "udit5");
		hashTable.insertValue(15, "udit6");
		hashTable.insertValue(16, "udit7");
		boolean actual = hashTable.insertValue(17, "Udit8");
		assertEquals(false, actual);
	}

	@Test
	public void GivenKeyIsValidWhenHashFunctionThenKey() {
		int actual = hashTable.hashFunction(10);
		assertEquals(3, actual);
	}

	@Test(expected = NullPointerException.class)
	public void GivenKeyIsNullWhenHashFunctionThenNullPointerException() {
		hashTable.hashFunction(null);
	}

	@Test
	public void GivenMultipleValuesAreAvailableWhenGetAllValuesThenValues() {
		hashTable.insertValue(10, "udit1");
		hashTable.insertValue(11, "udit2");
		hashTable.insertValue(12, "udit3");
		hashTable.insertValue(13, "udit4");
		hashTable.insertValue(14, "udit5");
		List<String> actual = hashTable.getAllValues();
		String[] expected = { "udit5", "udit1", "udit2", "udit3", "udit4" };
		assertArrayEquals(expected, actual.toArray());
	}
}
