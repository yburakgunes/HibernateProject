package com.bilgeadam.hql;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.StudentEntity;
import com.bilgeadam.util.HibernateUtil;

public class _01_HqlQuery_Select {
	private static final Logger logger = LogManager.getLogger(_01_HqlQuery_Select.class);
	
	public static void main(String[] args) {
		
		// interface uğramayacaksam mutlama yapmalıyız
		// HibernateUtil.getSessionfactor().openSession()
		// transaction yapmamıza gerek yok. Çünkü select işlemi yapıyoruz
		Session session = HibernateUtil.getSessionFactory().openSession();
		// SELECT * FROM bilge_adam.student;
		// unexpected end of subtree : içi boş
		// hql: Hibernate Query Language
		// hql: sql benzer ancak sql değildir
		// UNUTMA:from'dan sonra databasedeki tablo adını yazmayacağız Student Entity
		String hql = "select stu from StudentEntity as stu where studentId like 1";
		TypedQuery<StudentEntity> typedQuery = session.createQuery(hql, StudentEntity.class);
		
		ArrayList<StudentEntity> studentEntities = (ArrayList<StudentEntity>) typedQuery.getResultList();
		
		for (StudentEntity temp : studentEntities) {
			logger.info(temp);
			
		}
	}
}
