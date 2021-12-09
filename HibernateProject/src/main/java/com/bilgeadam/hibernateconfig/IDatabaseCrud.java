package com.bilgeadam.hibernateconfig;

import java.util.ArrayList;

import org.hibernate.Session;

import com.bilgeadam.util.HibernateUtil;

public interface IDatabaseCrud<T> {
	// CRUD
	
	public void create(T t);
	
	public void delete(T t);
	
	public void update(T t);
	
	default ArrayList<T> list() {
		return null;
	}
	
	default T singleResult(long id) {
		return null;
	}
	
	default T find(long id) {
		return null;
	}
	
	default Session databaseConnectionHibernate() {
		
		return HibernateUtil.getSessionFactory().openSession();
	}
}
