package com.webberis.vet.service;

import java.util.List;

public interface GenericService<T> {
	
	public int save (T element);
	
	public void update (T element);
	
	public void delete (T element);
	
	public List<T> getAll ();
	
	public T get (int id);

}
