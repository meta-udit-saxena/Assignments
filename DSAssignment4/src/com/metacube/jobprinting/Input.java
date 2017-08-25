/** 
 * @author Udit Saxena
 * @project Room Allotment using Hash Table
 * 
 */
package com.metacube.jobprinting;

import java.util.HashMap;

/**
 * The Class Input.
 */
public class Input {
	
	/** The priority map. */
	HashMap<String, Integer> priorityMap = new HashMap<>();
	
	/**
	 * Instantiates a new input.
	 */
	public Input(){
	priorityMap.put("chairman", 4);
	priorityMap.put("professors", 3);
	priorityMap.put("graduate", 2);
	priorityMap.put("undergraduates", 1);
	}
	
	/**
	 * Gets the priority map.
	 *
	 * @return the priority map
	 */
	public HashMap<String, Integer> getPriorityMap() {
		return priorityMap;
	}
	
	/**
	 * Sets the priority map.
	 *
	 * @param priorityMap
	 *            the priority map
	 */
	public void setPriorityMap(HashMap<String, Integer> priorityMap) {
		this.priorityMap = priorityMap;
	}
	
}
