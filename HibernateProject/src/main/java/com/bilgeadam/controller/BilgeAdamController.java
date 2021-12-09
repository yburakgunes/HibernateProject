package com.bilgeadam.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.BilgeAdamEntity;
import com.bilgeadam.hibernateconfig.IDatabaseCrud;

public class BilgeAdamController implements Serializable, IDatabaseCrud<BilgeAdamEntity> {
	
	private static final long serialVersionUID = -1213775719782464391L;
	private static final Logger logger = LogManager.getLogger(BilgeAdamController.class);
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
	public void create(BilgeAdamEntity entity) {
		
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("Ekleme işlemi tamamlandı" + BilgeAdamController.class);
		} catch (Exception e) {
			logger.error("Ekleme işlemi sırasında bir hata meydana geldi" + BilgeAdamController.class);
			e.printStackTrace();
		}
		
	}
	
	// silmek
	@Override
	public void delete(BilgeAdamEntity entity) {
		try {
			BilgeAdamEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				logger.info("Silme işlemi tamamlandı" + BilgeAdamController.class);
			}
		} catch (Exception e) {
			logger.error("Silme işlemi sırasında bir hata meydana geldi" + BilgeAdamController.class);
			e.printStackTrace();
		}
		
	}
	
	// güncellemek
	@Override
	public void update(BilgeAdamEntity entity) {
		try {
			BilgeAdamEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				findEntity.setEmail(entity.getEmail());
				// findEntity.setStudentName(entity.getStudentName());
				// findEntity.setStudentSurname(entity.getStudentSurname());
				// findEntity.setStudentPassword(entity.getStudentPassword());
				
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				logger.info("Güncelleme işlemi tamamlandı" + BilgeAdamController.class);
			}
		} catch (Exception e) {
			logger.error("Güncelleme işlemi sırasında bir hata meydana geldi" + BilgeAdamController.class);
			e.printStackTrace();
		}
		
	}
	
	// listelemek
	@Override
	public ArrayList<BilgeAdamEntity> list() {
		Session session = databaseConnectionHibernate();
		
		// Unutma: buradaki sorgulama entity sorgulaması java classına göre çağıracağız.
		String hql = "select str from BilgeAdamEntity as str where str.id>=:key";
		TypedQuery<BilgeAdamEntity> typedQuery = session.createQuery(hql, BilgeAdamEntity.class);
		
		long id = 1L;
		typedQuery.setParameter("key", id);
		
		ArrayList<BilgeAdamEntity> arrayList = (ArrayList<BilgeAdamEntity>) typedQuery.getResultList();
		
		return arrayList;
	}
	
	// find
	@Override
	public BilgeAdamEntity singleResult(long id) {
		// TODO Auto-generated method stub
		return IDatabaseCrud.super.singleResult(id);
	}
	
	// tek kayıt dönder
	@Override
	public BilgeAdamEntity find(long id) {
		Session session = databaseConnectionHibernate();
		BilgeAdamEntity bilgeAdamEntity;
		
		try {
			bilgeAdamEntity = session.find(BilgeAdamEntity.class, id);
			
			if (bilgeAdamEntity != null) {
				logger.info("bulundu..." + bilgeAdamEntity);
				return bilgeAdamEntity;
			} else {
				logger.info("Aradığınız kriterde sonuçlar bulunamadı ...");
				return null;
			}
			
		} catch (Exception e) {
			logger.error("Aradığınız bulunamadı" + BilgeAdamController.class);
			e.printStackTrace();
		}
		
		return null;
	}
	
}
