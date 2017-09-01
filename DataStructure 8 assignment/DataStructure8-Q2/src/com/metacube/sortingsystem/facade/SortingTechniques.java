package com.metacube.sortingsystem.facade;

import com.metacube.sortingsystem.dto.SortResponse;

/**
 * The Interface SortingTechniques implemented by all sorting facade.
 */
public interface SortingTechniques {

	/**
	 * Sort the array.
	 *
	 * @param array
	 *            the array
	 * @return the sort response contains sorted array and message
	 */
	public SortResponse sort(int[] array);
}