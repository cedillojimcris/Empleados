package com.mx.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEES")
public class Employees {

	/*CREATE TABLE EMPLOYEES(
    ID NUMBER(2,0) PRIMARY KEY,
    GENDER_ID NUMBER(2,0),
    JOB_ID NUMBER(2,0),
    NAME NVARCHAR2(255),
    LAST_NAME NVARCHAR2(255),
    BIRTHDATE DATE,
    CONSTRAINT FK_EMPLOYEES_GENDER FOREIGN KEY(GENDER_ID) REFERENCES GENDERS(ID),
    CONSTRAINT FK_EMPLOYEES_JOB FOREIGN KEY(JOB_ID) REFERENCES JOBS(ID)
 );*/
	
	@Id
	int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="GENDER_ID")
	Genders genders;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="JOB_ID")
	Jobs jobs;
	
	String name;
	String last_name;
	Date birthdate;
	
	@OneToMany(mappedBy="employees", cascade = CascadeType.ALL)
	List<EmployeeWorkedHours> lista = new ArrayList<EmployeeWorkedHours>();
	
	public Employees() {
		
	}
	
	public Employees(int id, Genders genders, Jobs jobs, String name, String last_name, Date birthdate) {
		this.id = id;
		this.genders = genders;
		this.jobs = jobs;
		this.name = name;
		this.last_name = last_name;
		this.birthdate = birthdate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Genders getGenders() {
		return genders;
	}
	public void setGenders(Genders genders) {
		this.genders = genders;
	}
	public Jobs getJobs() {
		return jobs;
	}
	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", genders=" + genders + ", jobs=" + jobs + ", name=" + name + ", last_name="
				+ last_name + ", birthdate=" + birthdate + "]";
	}

	
	
	
	
	
}
