package com.metacube.shoppingCart.Factory;

import com.metacube.shoppingCart.Dao.BaseDao;
import com.metacube.shoppingCart.Dao.InMemoryCartDao;
import com.metacube.shoppingCart.Dao.InMemoryProductStoreDao;
import com.metacube.shoppingCart.Enum.DBType;
import com.metacube.shoppingCart.Enum.Entity;

/**
 * @author Udit Saxena
 * 
 */
public class DaoFactory {

	/**
	 * @param entityName
	 *            - Name of entity
	 * @param dbType
	 *            - Database type
	 * @return the instance of entity
	 */
	public static BaseDao<?> getBaseDaoForEntity(Entity entityName,
			DBType dbType) {
		switch (entityName) {
		case Product:
			switch (dbType) {
			case Inmemory:
				return InMemoryProductStoreDao.getInstance();
			default:
				break;
			}
			break;
		case Cart:
			switch (dbType) {
			case Inmemory:
				return InMemoryCartDao.getInstance();
			default:
				break;
			}
		default:
			break;
		}
		
		return null;
	}
}
