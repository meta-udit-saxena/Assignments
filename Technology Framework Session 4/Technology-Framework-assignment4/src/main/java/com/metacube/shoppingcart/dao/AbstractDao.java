package com.metacube.shoppingcart.dao;

import java.io.Serializable;

import com.metacube.shoppingcart.enums.Status;

/**
 * The Interface AbstractDao.
 *
 * @param <T>
 *            the generic type
 * @param <ID>
 *            the generic type
 */
public interface AbstractDao<T, ID extends Serializable> {

	/**
	 * Adds the.
	 *
	 * @param <S>
	 *            the generic type
	 * @param entity
	 *            the entity
	 * @return the status
	 *//*
	<S extends T> Status add(S entity);

	*//**
	 * Find one.
	 *
	 * @param primaryKey
	 *            the primary key
	 * @return the t
	 *//*
	T findOne(ID primaryKey);
*/
	
	
	/**
	 * Find all.
	 *
	 * @return the iterable
	 */
	Iterable<T> findAll();

	
	
	
	/**
	 * Find dashboard.
	 *
	 * @return the iterable
	 *//*
	Iterable<T> findDashboard();

	*//**
	 * Delete.
	 *
	 * @param id
	 *            the id
	 * @return the status
	 *//*
	Status delete(int id);

	*//**
	 * Update product.
	 *
	 * @param <S>
	 *            the generic type
	 * @param entity
	 *            the entity
	 * @param id
	 *            the id
	 * @return the status
	 *//*
	<S extends T> Status updateProduct(S entity, int id);*/
}
