package com.bilgeadam.hql;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.StudentEntity;
import com.bilgeadam.util.HibernateUtil;

public class _09_Aggregate_Between {
	// logger
	private static final Logger logger = LogManager.getLogger(_09_Aggregate_Between.class);
	
	public static void main(String[] args) {
		
		// session
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		// NormalSql
		// select * from student where tc_number>=105
		
		// String hql = "select stu from StudentEntity as stu where tc_number >=105";
		String hql = "select stu from StudentEntity as stu where tc_number between :minKey and :maxKey";
		
		int minValue = 104, maxKey = 107;
		TypedQuery<StudentEntity> typedQuery = session.createQuery(hql, StudentEntity.class);
		typedQuery.setParameter("minKey", minValue);
		typedQuery.setParameter("maxKey", maxKey);
		ArrayList<StudentEntity> studentEntities = (ArrayList<StudentEntity>) typedQuery.getResultList();
		
		for (StudentEntity temp : studentEntities) {
			logger.info(temp);
		}
	}
}
