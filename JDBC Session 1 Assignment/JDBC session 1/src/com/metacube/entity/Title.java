package com.metacube.entity;

/**
 * The Class Title.
 */
public class Title {
	private String titleId;
	private String titleName;

	/**
	 * Instantiates a new title.
	 *
	 * @param titleId
	 *            the title id
	 * @param titleName
	 *            the title name
	 */
	public Title(String titleId, String titleName) {
		this.titleId = titleId;
		this.titleName = titleName;
	}

	/**
	 * Gets the title id.
	 *
	 * @return the title id
	 */
	public String getTitleId() {
		return this.titleId;
	}

	/**
	 * Gets the title name.
	 *
	 * @return the title name
	 */
	public String getTitleName() {
		return this.titleName;
	}
}