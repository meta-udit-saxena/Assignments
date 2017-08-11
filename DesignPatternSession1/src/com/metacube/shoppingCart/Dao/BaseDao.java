package com.metacube.shoppingCart.Dao;

import com.metacube.shoppingCart.Model.Entity;

public interface BaseDao {
	
	public void create(Entity entity);
	public void update(Entity entity);
	public void delete(Entity entity);
	public Entity retreive();
}
