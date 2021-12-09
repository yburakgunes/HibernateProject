package com.bilgeadam.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bilgeadam.entity.BilgeAdamEntity;
import com.bilgeadam.entity.ETicaretEntity;
import com.bilgeadam.entity.PencilEntity;
import com.bilgeadam.entity.StudentEntity;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = sessionFactoryHibernate();
	
	private static SessionFactory sessionFactoryHibernate() {
		
		try {
			
			// instance
			Configuration configuration = new Configuration();
			
			// entity classlarımızı buraya ekleyeceğiz
			configuration.addAnnotatedClass(StudentEntity.class);
			configuration.addAnnotatedClass(BilgeAdamEntity.class);
			configuration.addAnnotatedClass(ETicaretEntity.class);
			configuration.addAnnotatedClass(PencilEntity.class);
			
			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
			return factory;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
