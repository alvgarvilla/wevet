package com.webberis.vet.management.pet;

import java.util.List;

import com.webberis.vet.beans.Pet;
import com.webberis.vet.exceptions.BusinessException;

public interface PetManagementUC {
	
	public int newPet(Pet pet) throws BusinessException;
	
	public void deletePet (Pet pet) throws BusinessException;
	
	public void getAllPets() throws BusinessException;
	
	public void getPetById() throws BusinessException;
	
	public List<Pet> getPetsByPet (Pet pet) throws BusinessException;

}
