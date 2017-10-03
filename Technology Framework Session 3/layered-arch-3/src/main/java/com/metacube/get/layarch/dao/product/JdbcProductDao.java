package com.metacube.get.layarch.dao.product;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.metacube.get.layarch.dao.GenericJdbcDao;
import com.metacube.get.layarch.model.Product;

/**
 * The Class JdbcProductDao.
 */
@Component("productDao")
public class JdbcProductDao extends GenericJdbcDao<Product, Integer> implements
		ProductDao {

	/**
	 * Gets the table name.
	 *
	 * @return the table name
	 */
	@Override
	public String getTableName() {
		return "Product";
	}

	/**
	 * Extract result set row.
	 *
	 * @param resultSet
	 *            the result set
	 * @return the t
	 */
	@Override
	protected Product extractResultSetRow(final ResultSet resultSet) {
		Product product = new Product();

		try {
			product.setName(resultSet.getString("name"));
			product.setPrice(resultSet.getDouble("price"));
			product.setDescription(resultSet.getString("description"));
			product.setId(resultSet.getInt("id"));
			product.setCurrency(resultSet.getString("currency"));
			product.setImagePath(resultSet.getString("imagePath"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return product;
	}

	/**
	 * Gets the primary key column name.
	 *
	 * @return the primary key column name
	 */
	@Override
	protected String getPrimaryKeyColoumnName() {
		return "id";
	}

}
