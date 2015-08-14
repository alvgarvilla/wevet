package com.webberis.vet.dao;

import java.util.List;

public interface GenericDAO<T> {
	
	public T save(Object object);
	
	public void update(Object object);
	
	public void delete(Object element);
	
	public List<T> getAll(Class<T> clazz);
	
	public T get(Class<T> clazz, int id);

}
