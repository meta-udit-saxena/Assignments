package com.metacube.shoppingCart.Dao;

import java.util.Map;

import com.metacube.shoppingCart.Entity.BaseEntity;

/**
 * BaseDao interface extended by all Dao Interfaces
 * 
 * @author Udit Saxena
 * @param <T>
 *            generic type only of entity
 */
public interface BaseDao<T extends BaseEntity> {

	/**
	 * Add entity to the list
	 * 
	 * @param entityId
	 * @param entity
	 *            - BaseEntity Object
	 */
	public void add(int entityId, BaseEntity entity);

	/**
	 * Remove entity from the list
	 * 
	 * @param entityId
	 */
	public void remove(int entityId);

	/**
	 * @return the Map of Entity
	 */
	public Map<Integer, BaseEntity> getList();
}
