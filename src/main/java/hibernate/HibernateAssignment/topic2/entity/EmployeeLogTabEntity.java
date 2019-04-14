package hibernate.HibernateAssignment.topic2.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeLogTab")
public class EmployeeLogTabEntity {

	private Integer id;
	private Integer empCode;
	private String empName;
	private String empDesignation;
	private Double lastDrawnSalary;
	private Date leavingDate;
	
	public EmployeeLogTabEntity() {
		
	}
	
	public EmployeeLogTabEntity(Integer empCode, String empName, String empDesignation, Double lastDrawnSalary, Date leavingDate) {
		
		this.empCode = empCode;
		this.empName = empName;
		this.empDesignation = empDesignation;
		this.lastDrawnSalary = lastDrawnSalary;
		this.leavingDate = leavingDate;
	}
	
	@Id
	@GeneratedValue
	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="empCode")
	public Integer getEmpCode() {
		return empCode;
	}
	public void setEmpCode(Integer empCode) {
		this.empCode = empCode;
	}
	
	@Column(name="empName")
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	@Column(name="empDesignation")
	public String getEmpDesignation() {
		return empDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
	
	@Column(name="lastDrawnSalary")
	public Double getLastDrawnSalary() {
		return lastDrawnSalary;
	}
	public void setLastDrawnSalary(Double lastDrawnSalary) {
		this.lastDrawnSalary = lastDrawnSalary;
	}
	
	@Column(name="leavingDate")
	public Date getLeavingDate() {
		return leavingDate;
	}
	public void setLeavingDate(Date leavingDate) {
		this.leavingDate = leavingDate;
	}
}
