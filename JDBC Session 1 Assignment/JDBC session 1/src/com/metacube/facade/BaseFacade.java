package com.metacube.facade;

/**
 * The Interface BaseFacade.
 *
 * @param <E> the element type
 */
public interface BaseFacade<E> {

	
	/**
	 * Gets the single instance of BaseFacade.
	 *
	 * @return single instance of BaseFacade
	 */
	public E getInstance();
}
