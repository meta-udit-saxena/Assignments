package com.metacube.shoppingcart.dao;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.model.Product;

/**
 * The Class HibernateDao.
 *
 * @param <T>
 *            the generic type
 * @param <ID>
 *            the generic type
 */
public abstract class HibernateDao<T, ID extends Serializable> implements
		AbstractDao<T, ID> {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Gets the session factory.
	 *
	 * @return the session factory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Sets the session factory.
	 *
	 * @param sessionFactory
	 *            the new session factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** The model class. */
	private Class<T> modelClass;

	/**
	 * Gets the model class.
	 *
	 * @return the model class
	 */
	public Class<T> getModelClass() {
		return modelClass;
	}

	/**
	 * Instantiates a new hibernate dao.
	 *
	 * @param modelClass
	 *            the model class
	 */
	public HibernateDao(Class<T> modelClass) {
		this.modelClass = modelClass;
	}

	@Override
	public Iterable<T> findAll() {
		List<T> productList = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(getModelClass());
			productList = cr.list();

		} catch (Exception e) {
			productList = Collections.emptyList();
		}
		return productList;
	}

	@Override
	public Iterable<T> findDashboard() {
		List<T> productList = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(getModelClass());
			productList = cr.list().subList(0, 8);

		} catch (Exception e) {
			productList = Collections.emptyList();
		}
		return productList;
	}

	@Override
	public T findOne(final ID primaryKey) {
		Product product = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			product = (Product) session.get(Product.class, primaryKey);
		} catch (Exception e) {

		}

		return (T) product;
	}

	@Override
	public Status delete(int primaryKey) {
		Status result = Status.Success;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Product product = (Product) session.get(Product.class, primaryKey);
			session.delete(product);
		} catch (Exception e) {
			result = Status.Error_Occured;
		}
		return result;

	}

	@Override
	public <S extends T> Status add(final S entity) {
		Status result = Status.Success;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.save(entity);
		} catch (Exception e) {
			result = Status.Error_Occured;
		}
		return result;
	}

	@Override
	public <S extends T> Status updateProduct(S entity, int id) {
		Status result = Status.Added;
		try {

			Session session = this.sessionFactory.getCurrentSession();
			Product update = (Product) entity;
			Product product = (Product) session.get(Product.class, id);
			product.setName(update.getName());
			product.setPrice(update.getPrice());
			product.setCurrency(update.getCurrency());
			product.setDescription(update.getDescription());
			product.setImagePath(update.getImagePath());
			session.update(product);

		} catch (Exception e) {
			result = Status.Error_Occured;
		}

		return result;
	}
}
