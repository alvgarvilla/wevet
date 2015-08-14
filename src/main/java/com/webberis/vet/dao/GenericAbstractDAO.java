package com.webberis.vet.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericAbstractDAO<T> {

	@Autowired
	SessionFactory sessionFactory;

	private static final Logger logger = Logger.getLogger(GenericAbstractDAO.class);

	protected Session getSession() {
		logger.info("Getting Hibernate session");
		try {
			return sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			logger.error("Error while getting Hibernate session", e);
			throw e;
		}
	}

	public void persist(Object entity) {
		logger.info("Persisting element " + entity.getClass().getName());
		try {
			getSession().persist(entity);
		} catch (HibernateException e) {
			logger.error("Error while persisting element " + entity.getClass().getName(), e);
			throw e;
		}
	}

	public void update(Object entity) {
		logger.info("Updating element " + entity.getClass().getName());
		try {
			getSession().update(entity);
		} catch (HibernateException e) {
			logger.error("Error while updating element " + entity.getClass().getName(), e);
			throw e;
		}
	}

	public void delete(Object entity) {
		logger.info("Deleting element " + entity.getClass().getName());
		try {
			getSession().delete(entity);
		} catch (HibernateException e) {
			logger.error("Error while deleting element " + entity.getClass().getName(), e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll(Class<T> clazz) {
		logger.info("Getting all elements " + clazz.getName());
		try {
			Criteria criteria = getSession().createCriteria(clazz);
			return (List<T>) criteria.list();
		} catch (HibernateException e) {
			logger.error("Error while getting all elements " + clazz.getName(), e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public T get(Class<T> clazz, int id) {
		logger.info("Getting element " + clazz.getName());
		try {
			return (T) getSession().get(clazz, id);
		} catch (HibernateException e) {
			logger.error("Error while getting element " + clazz.getName(), e);
			throw e;
		}
	}

}
