package com.webberis.vet.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OWNER")
public class Pet {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@ManyToOne()
	@JoinColumn(name = "BREED_ID")
	private Breed breed;
	
	@Column(name = "GENDER", nullable = false)
	private int gender;
	
	@Column(name = "COLOUR", nullable = false)
	private String colour;
	
	@ManyToOne()
	@JoinColumn(name = "OWNER_ID")
	private Owner owner;
	
	@Column(name = "DATE_BIRTH")
	private Date dateBirth;
	
	@Column(name = "DATE_ENROL")
	private Date dateEnrol;
	
	public Pet(){
		
	}

	public Pet(int id, String name, Breed breed, int gender, String colour, Owner owner, Date dateBirth,
			Date dateEnrol) {
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.gender = gender;
		this.colour = colour;
		this.owner = owner;
		this.dateBirth = dateBirth;
		this.dateEnrol = dateEnrol;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Breed getBreed() {
		return breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public Date getDateEnrol() {
		return dateEnrol;
	}

	public void setDateEnrol(Date dateEnrol) {
		this.dateEnrol = dateEnrol;
	}
	
	

}
