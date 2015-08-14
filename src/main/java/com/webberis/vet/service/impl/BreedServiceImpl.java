package com.webberis.vet.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webberis.vet.beans.Breed;
import com.webberis.vet.dao.GenericDAO;
import com.webberis.vet.service.GenericService;

@Service("breedService")
@Transactional()
public class BreedServiceImpl implements GenericService<Breed>{

	private static final Logger logger = Logger.getLogger(BreedServiceImpl.class);
	
	@Autowired
	GenericDAO<Breed> breedDao;
	
	public int save(Breed element) {
		logger.info("Saving a Breed element");
		try {
			Breed breed = breedDao.save(element);
			return breed.getId();			
		} catch (HibernateException e) {
			logger.error("There was an error while saving an Breed element", e);
			throw e;
		}
	}

	public void update(Breed element) {
		logger.info("Updating a Breed element");
		try {
			breedDao.update(element);			
		} catch (HibernateException e) {
			logger.error("There was an error while updating a Breed element", e);			
			throw e;
		}	
	}

	public void delete(Breed element) {
		logger.info("Deleting a Breed element");
		try {
			breedDao.delete(element);			
		} catch (HibernateException e) {
			logger.error("There was an error while deleting a Breed element", e);			
			throw e;
		}	
	}

	public List<Breed> getAll() {
		logger.info("Getting all Breed elements");
		try {
			return breedDao.getAll(Breed.class);			
		} catch (HibernateException e) {
			logger.error("There was an error while getting all Breed elements", e);
			throw e;
		}	
	}

	public Breed get(int id) {
		logger.info("Getting Breed element");
		try {
			return breedDao.get(Breed.class, id);			
		} catch (HibernateException e) {
			logger.error("There was an error while getting a Breed element", e);
			throw e;
		}
	}

}
