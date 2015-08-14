package com.webberis.vet.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webberis.vet.beans.Owner;
import com.webberis.vet.dao.GenericDAO;
import com.webberis.vet.service.GenericService;

@Service("ownerService")
@Transactional()
public class OwnerServiceImpl implements GenericService<Owner>{

	private static final Logger logger = Logger.getLogger(OwnerServiceImpl.class);
	
	@Autowired
	GenericDAO<Owner> ownerDao;
	
	public int save(Owner element) {
		logger.info("Saving a Owner element");
		try {
			Owner owner = ownerDao.save(element);
			return owner.getId();			
		} catch (HibernateException e) {
			logger.error("There was an error while saving an Owner element", e);
			throw e;
		}
	}

	public void update(Owner element) {
		logger.info("Updating a Owner element");
		try {
			ownerDao.update(element);			
		} catch (HibernateException e) {
			logger.error("There was an error while updating a Owner element", e);			
			throw e;
		}	
	}

	public void delete(Owner element) {
		logger.info("Deleting a Owner element");
		try {
			ownerDao.delete(element);			
		} catch (HibernateException e) {
			logger.error("There was an error while deleting a Owner element", e);			
			throw e;
		}	
	}

	public List<Owner> getAll() {
		logger.info("Getting all Owner elements");
		try {
			return ownerDao.getAll(Owner.class);			
		} catch (HibernateException e) {
			logger.error("There was an error while getting all Owner elements", e);
			throw e;
		}	
	}

	public Owner get(int id) {
		logger.info("Getting Owner element");
		try {
			return ownerDao.get(Owner.class, id);			
		} catch (HibernateException e) {
			logger.error("There was an error while getting a Owner element", e);
			throw e;
		}
	}

}
