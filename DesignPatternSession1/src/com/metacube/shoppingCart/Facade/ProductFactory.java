package com.metacube.shoppingCart.Facade;

import com.metacube.shoppingCart.Dao.BaseDao;
import com.metacube.shoppingCart.Dao.InMemoryProductDao;

public class ProductFactory {
	
	public static BaseDao getInstance(String str){
		switch(str){
		case "InMemoryProductDao":
			return (BaseDao)new InMemoryProductDao();
		default:
			return null;
		}
	}
}
