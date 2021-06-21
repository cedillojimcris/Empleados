package com.mx.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "JOBS")
public class Jobs {
	
	/*CREATE TABLE JOBS(
    ID NUMBER(2,0) PRIMARY KEY,
    NAME NVARCHAR2(255),
    SALARY NUMBER(9,2)
);*/
	
	@Id
	int id;
	String name;
	double salary;
	
	@OneToMany(mappedBy = "jobs", cascade=CascadeType.ALL)
	List<Employees> lista = new ArrayList<Employees>();
	
	public Jobs() {
		
	}
	
	public Jobs(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Jobs [id=" + id + ", name=" + name + ", salary=" + salary + ", lista=" + lista + "]";
	}

	
	
	

}
