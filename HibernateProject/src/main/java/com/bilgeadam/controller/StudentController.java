package com.bilgeadam.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.StudentEntity;
import com.bilgeadam.hibernateconfig.IDatabaseCrud;

public class StudentController implements Serializable, IDatabaseCrud<StudentEntity> {
	
	private static final long serialVersionUID = -1213775719782464391L;
	private static final Logger logger = LogManager.getLogger(StudentController.class);
	// trace < debug < info < warn < error < fatal < off
	
	public static void main(String[] args) {
		logger.trace("trace logger durumu");
		logger.debug("debug logger durumu");
		logger.info("info logger durumu");
		logger.warn("warn logger durumu");
		logger.error("error logger durumu");
		logger.fatal("fatal logger durumu");
	}
	
	// create: Persist
	// delete: Remove
	// DML = Create Delete Update:transaction is a must!
	// DQL = Select:transaction isteğe bağlı
	// find = find (bulmak)
	
	// create
	@Override
	public void create(StudentEntity entity) {
		
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("Ekleme işlemi tamamlandı" + StudentController.class);
		} catch (Exception e) {
			logger.error("Ekleme işlemi sırasında bir hata meydana geldi" + StudentController.class);
			e.printStackTrace();
		}
		
	}
	
	// silmek
	@Override
	public void delete(StudentEntity entity) {
		try {
			StudentEntity findEntity = find(entity.getStudentId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				logger.info("Silme işlemi tamamlandı" + StudentController.class);
			}
		} catch (Exception e) {
			logger.error("Silme işlemi sırasında bir hata meydana geldi" + StudentController.class);
			e.printStackTrace();
		}
		
	}
	
	// güncellemek
	@Override
	public void update(StudentEntity entity) {
		try {
			StudentEntity findEntity = find(entity.getStudentId());
			if (findEntity != null) {
				findEntity.setEmailAddress(entity.getEmailAddress());
				findEntity.setStudentName(entity.getStudentName());
				findEntity.setStudentSurname(entity.getStudentSurname());
				findEntity.setStudentPassword(entity.getStudentPassword());
				
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				logger.info("Güncelleme işlemi tamamlandı" + StudentController.class);
			}
		} catch (Exception e) {
			logger.error("Güncelleme işlemi sırasında bir hata meydana geldi" + StudentController.class);
			e.printStackTrace();
		}
		
	}
	
	// listelemek
	@Override
	public ArrayList<StudentEntity> list() {
		Session session = databaseConnectionHibernate();
		
		// Unutma: buradaki sorgulama entity sorgulaması java classına göre çağıracağız.
		String hql = "select str from StudentEntity as str where str.id>=:key";
		TypedQuery<StudentEntity> typedQuery = session.createQuery(hql, StudentEntity.class);
		
		long id = 1L;
		typedQuery.setParameter("key", id);
		
		ArrayList<StudentEntity> arrayList = (ArrayList<StudentEntity>) typedQuery.getResultList();
		
		return arrayList;
	}
	
	// find
	@Override
	public StudentEntity singleResult(long id) {
		// TODO Auto-generated method stub
		return IDatabaseCrud.super.singleResult(id);
	}
	
	// tek kayıt dönder
	@Override
	public StudentEntity find(long id) {
		Session session = databaseConnectionHibernate();
		StudentEntity studentEntity;
		
		try {
			studentEntity = session.find(StudentEntity.class, id);
			
			if (studentEntity != null) {
				logger.info("bulundu..." + studentEntity);
				return studentEntity;
			} else {
				logger.info("Aradığınız kriterde sonuçlar bulunamadı ...");
				return null;
			}
			
		} catch (Exception e) {
			logger.error("Aradığınız bulunamadı" + StudentController.class);
			e.printStackTrace();
		}
		
		return null;
	}
	
}
