package com.webberis.vet.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webberis.vet.beans.Family;
import com.webberis.vet.dao.GenericDAO;
import com.webberis.vet.service.GenericService;

@Service("familyService")
@Transactional()
public class FamilyServiceImpl implements GenericService<Family>{

	private static final Logger logger = Logger.getLogger(FamilyServiceImpl.class);
	
	@Autowired
	GenericDAO<Family> familyDao;
	
	public int save(Family element) {
		logger.info("Saving a Family element");
		try {
			Family family = familyDao.save(element);
			return family.getId();			
		} catch (HibernateException e) {
			logger.error("There was an error while saving an Family element", e);
			throw e;
		}
	}

	public void update(Family element) {
		logger.info("Updating a Family element");
		try {
			familyDao.update(element);			
		} catch (HibernateException e) {
			logger.error("There was an error while updating a Family element", e);			
			throw e;
		}	
	}

	public void delete(Family element) {
		logger.info("Deleting a Family element");
		try {
			familyDao.delete(element);			
		} catch (HibernateException e) {
			logger.error("There was an error while deleting a Family element", e);			
			throw e;
		}	
	}

	public List<Family> getAll() {
		logger.info("Getting all Family elements");
		try {
			return familyDao.getAll(Family.class);			
		} catch (HibernateException e) {
			logger.error("There was an error while getting all Family elements", e);
			throw e;
		}	
	}

	public Family get(int id) {
		logger.info("Getting Family element");
		try {
			return familyDao.get(Family.class, id);			
		} catch (HibernateException e) {
			logger.error("There was an error while getting a Family element", e);
			throw e;
		}
	}

}
