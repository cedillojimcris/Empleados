package com.mx.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_WORKED_HOURS")
public class EmployeeWorkedHours {

	/* CREATE TABLE EMPLOYEE_WORKED_HOURS(
    ID NUMBER(2,0) PRIMARY KEY,
    EMPLOYEE_ID NUMBER(2,0),
    WORKED_HOURS NUMBER(3,0),
    WORKED_DATE DATE,
    CONSTRAINT FK_HOURS_EMPLOYEE FOREIGN KEY(EMPLOYEE_ID) REFERENCES EMPLOYEES(ID)
 );*/
	
	@Id
	int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="EMPLOYEE_ID")
	Employees employees;
	
	int worked_hours;
	Date worked_date;
	
	public EmployeeWorkedHours() {
		
	}
	
	public EmployeeWorkedHours(int id, Employees employees, int worked_hours, Date worked_date) {
		this.id = id;
		this.employees = employees;
		this.worked_hours = worked_hours;
		this.worked_date = worked_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employees getEmployees() {
		return employees;
	}
	public void setEmployees(Employees employees) {
		this.employees = employees;
	}
	public int getWorked_hours() {
		return worked_hours;
	}
	public void setWorked_hours(int worked_hours) {
		this.worked_hours = worked_hours;
	}
	public Date getWorked_date() {
		return worked_date;
	}
	public void setWorked_date(Date worked_date) {
		this.worked_date = worked_date;
	}

	@Override
	public String toString() {
		return "EmployeeWorkedHours [id=" + id + ", employees=" + employees + ", worked_hours=" + worked_hours
				+ ", worked_date=" + worked_date + "]";
	}
	
	
	
}
