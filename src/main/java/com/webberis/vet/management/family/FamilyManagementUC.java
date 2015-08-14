package com.webberis.vet.management.family;

import java.util.List;

import com.webberis.vet.beans.Owner;
import com.webberis.vet.beans.Pet;
import com.webberis.vet.exceptions.BusinessException;

public interface FamilyManagementUC {
	
	public int newOwner(Owner owner) throws BusinessException;
	
	public void deleteOwner (Owner owner) throws BusinessException;
	
	public void getAllOwners() throws BusinessException;
	
	public void getOwnerById() throws BusinessException;
	
	public List<Pet> getPetsByOwner (Owner owner) throws BusinessException;

}
