package com.metacube.sortingsystem.dto;

/**
 * The Class ControllerResponse.
 */
public class ControllerResponse {

	/** The message. */
	public String message;

	/** The sorted array. */
	public int[] sortedArray;

	/**
	 * Instantiates a new controller response.
	 */
	public ControllerResponse() {
		this.message = "Empty Array";
		this.sortedArray = new int[] {};
	}
}