package com.bilgeadam.hql;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.util.HibernateUtil;

public class _07_Aggregate_Distinct {
	// logger
	private static final Logger logger = LogManager.getLogger(_07_Aggregate_Distinct.class);
	
	public static void main(String[] args) {
		
		// session
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		// Bütün listeyi çağır
		// String hql = "from StudentEntity as stu";
		
		// tekrarlı verileri çağırma
		String hql = "select distinct(bigData) from StudentEntity as stu";
		
		TypedQuery<String> typedQuery = session.createQuery(hql, String.class);
		ArrayList<String> studentEntities = (ArrayList<String>) typedQuery.getResultList();
		
		for (String temp : studentEntities) {
			logger.info(temp);
		}
	}
}
