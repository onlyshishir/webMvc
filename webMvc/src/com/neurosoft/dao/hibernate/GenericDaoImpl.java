package com.neurosoft.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.neurosoft.dao.GenericDao;

public class GenericDaoImpl<T, PK extends Serializable> implements
		GenericDao<T, PK> {

	private HibernateTemplate hibernateTemplate;
	private Class<T> type;

	@Required
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	protected GenericDaoImpl(Class<T> type) {
		this.type = type;
	}

	@SuppressWarnings( { "unchecked" })
	public PK create(T o) {
		return (PK) getHibernateTemplate().save(o);
	}

	@SuppressWarnings( { "unchecked" })
	public T read(PK id) {
		return (T) getHibernateTemplate().get(type, id);
	}

	@SuppressWarnings( { "unchecked" })
	public List<T> loadAll() {
		return getHibernateTemplate().loadAll(type);
	}

	public void update(T o) {
		getHibernateTemplate().update(o);
	}

	public void createOrUpdate(T o) {
		getHibernateTemplate().saveOrUpdate(o);
	}

	public void delete(T o) {
		getHibernateTemplate().delete(o);
	}

}
