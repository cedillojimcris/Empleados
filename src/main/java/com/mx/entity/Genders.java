package com.mx.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="GENDERS")
public class Genders {
	
	/*CREATE TABLE GENDERS(
    ID NUMBER(2,0) PRIMARY KEY,
    NAME NVARCHAR2(255)
);*/
	
	@Id
	int id;
	String name;
	
	@OneToMany(mappedBy="genders", cascade = CascadeType.ALL )
	List<Employees> lista = new ArrayList<Employees>(); 
	
	public Genders() {
		
	}
	
	public Genders(int id, String name) {
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "Genders [id=" + id + ", name=" + name + "]";
	}
	
	

}
