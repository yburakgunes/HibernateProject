package com.bilgeadam.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.PencilEntity;
import com.bilgeadam.hibernateconfig.IDatabaseCrud;

public class PencilController implements Serializable, IDatabaseCrud<PencilEntity> {
	
	private static final long serialVersionUID = -1213775719782464391L;
	private static final Logger logger = LogManager.getLogger(PencilController.class);
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
	public void create(PencilEntity entity) {
		
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("Ekleme işlemi tamamlandı" + PencilController.class);
		} catch (Exception e) {
			logger.error("Ekleme işlemi sırasında bir hata meydana geldi" + PencilController.class);
			e.printStackTrace();
		}
		
	}
	
	// silmek
	@Override
	public void delete(PencilEntity entity) {
		try {
			PencilEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				logger.info("Silme işlemi tamamlandı" + PencilController.class);
			}
		} catch (Exception e) {
			logger.error("Silme işlemi sırasında bir hata meydana geldi" + PencilController.class);
			e.printStackTrace();
		}
		
	}
	
	// güncellemek
	@Override
	public void update(PencilEntity entity) {
		try {
			PencilEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				// findEntity.setEmail(entity.getEmail());
				// findEntity.setStudentName(entity.getStudentName());
				// findEntity.setStudentSurname(entity.getStudentSurname());
				// findEntity.setStudentPassword(entity.getStudentPassword());
				
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				logger.info("Güncelleme işlemi tamamlandı" + PencilController.class);
			}
		} catch (Exception e) {
			logger.error("Güncelleme işlemi sırasında bir hata meydana geldi" + PencilController.class);
			e.printStackTrace();
		}
		
	}
	
	// listelemek
	@Override
	public ArrayList<PencilEntity> list() {
		Session session = databaseConnectionHibernate();
		
		// Unutma: buradaki sorgulama entity sorgulaması java classına göre çağıracağız.
		String hql = "select str from PencilEntity as str where str.id>=:key";
		TypedQuery<PencilEntity> typedQuery = session.createQuery(hql, PencilEntity.class);
		
		long id = 1L;
		typedQuery.setParameter("key", id);
		
		ArrayList<PencilEntity> arrayList = (ArrayList<PencilEntity>) typedQuery.getResultList();
		
		return arrayList;
	}
	
	// find
	@Override
	public PencilEntity singleResult(long id) {
		// TODO Auto-generated method stub
		return IDatabaseCrud.super.singleResult(id);
	}
	
	// tek kayıt dönder
	@Override
	public PencilEntity find(long id) {
		Session session = databaseConnectionHibernate();
		PencilEntity pencilEntity;
		
		try {
			pencilEntity = session.find(PencilEntity.class, id);
			
			if (pencilEntity != null) {
				logger.info("bulundu..." + pencilEntity);
				return pencilEntity;
			} else {
				logger.info("Aradığınız kriterde sonuçlar bulunamadı ...");
				return null;
			}
			
		} catch (Exception e) {
			logger.error("Aradığınız bulunamadı" + PencilController.class);
			e.printStackTrace();
		}
		
		return null;
	}
	
}
