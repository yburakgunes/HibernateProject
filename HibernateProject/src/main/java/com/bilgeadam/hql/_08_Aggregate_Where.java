package com.bilgeadam.hql;

import java.util.ArrayList;

import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.StudentEntity;
import com.bilgeadam.util.HibernateUtil;

public class _08_Aggregate_Where {
	// logger
	private static final Logger logger = LogManager.getLogger(_08_Aggregate_Where.class);
	
	public static void main(String[] args) {
		
		// session
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		// NormalSql
		// select * from student where tc_number>=105
		
		// String hql = "select stu from StudentEntity as stu where tc_number >=105";
		String hql = "select stu from StudentEntity as stu where tc_number >=:key";
		String userValue = JOptionPane.showInputDialog("Lütfen bir sayı giriniz");
		int number = Integer.valueOf(userValue);
		
		// int number = 105;
		TypedQuery<StudentEntity> typedQuery = session.createQuery(hql, StudentEntity.class);
		typedQuery.setParameter("key", number);
		ArrayList<StudentEntity> studentEntities = (ArrayList<StudentEntity>) typedQuery.getResultList();
		
		for (StudentEntity temp : studentEntities) {
			logger.info(temp);
		}
	}
}
