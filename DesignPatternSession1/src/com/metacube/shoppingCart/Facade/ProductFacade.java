package com.metacube.shoppingCart.Facade;

import com.metacube.shoppingCart.Constants;
import com.metacube.shoppingCart.Dao.BaseDao;
import com.metacube.shoppingCart.Dao.FileHandling;


public interface ProductFacade {
	BaseDao object = ProductFactory.getInstance(FileHandling.read(Constants.FILELOC));
	
	
}
