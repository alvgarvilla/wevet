package com.webberis.vet.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webberis.vet.beans.Pet;
import com.webberis.vet.dao.GenericDAO;
import com.webberis.vet.service.GenericService;

@Service("petService")
@Transactional()
public class PetServiceImpl implements GenericService<Pet>{

	private static final Logger logger = Logger.getLogger(PetServiceImpl.class);
	
	@Autowired
	GenericDAO<Pet> petDao;
	
	public int save(Pet element) {
		logger.info("Saving a Pet element");
		try {
			Pet pet = petDao.save(element);
			return pet.getId();			
		} catch (HibernateException e) {
			logger.error("There was an error while saving an Pet element", e);
			throw e;
		}
	}

	public void update(Pet element) {
		logger.info("Updating a Pet element");
		try {
			petDao.update(element);			
		} catch (HibernateException e) {
			logger.error("There was an error while updating a Pet element", e);			
			throw e;
		}	
	}

	public void delete(Pet element) {
		logger.info("Deleting a Pet element");
		try {
			petDao.delete(element);			
		} catch (HibernateException e) {
			logger.error("There was an error while deleting a Pet element", e);			
			throw e;
		}	
	}

	public List<Pet> getAll() {
		logger.info("Getting all Pet elements");
		try {
			return petDao.getAll(Pet.class);			
		} catch (HibernateException e) {
			logger.error("There was an error while getting all Pet elements", e);
			throw e;
		}	
	}

	public Pet get(int id) {
		logger.info("Getting Pet element");
		try {
			return petDao.get(Pet.class, id);			
		} catch (HibernateException e) {
			logger.error("There was an error while getting a Pet element", e);
			throw e;
		}
	}

}
