package com.metacube.dto;

/**
 * The Class UniqueCharacterDTO.
 */
public class FindTotalUniqueCharacterDTO {

	/** if successful then true else false. */
	public boolean success;

	/** contains the result */
	public int result;

	/** true if data from cache else false */
	public boolean fromCache;

	/**
	 * Check if objects are equals or not
	 */
	@Override
	public boolean equals(Object obj) {
		FindTotalUniqueCharacterDTO other = (FindTotalUniqueCharacterDTO) obj;
		if (obj == null || getClass() != obj.getClass()
				|| this.fromCache != other.fromCache
				|| this.result != other.result || this.success != other.success) {
			return false;
		}

		return true;
	}
}