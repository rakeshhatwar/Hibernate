package hibernate.HibernateAssignment.topic2.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="ABC_EMPLOYEE_DETAILS")
public class ABCCompanyEmployeeEntity {

	private Integer empCode;
	private String empName;
	private String empDesignation;
	private Date empDOB;
	private Date empJOD;
	private Integer empAge;
	private Double empBasic_Pay;
	
	public ABCCompanyEmployeeEntity() {
		
	}
	
	public ABCCompanyEmployeeEntity(String empName, String empDesignation, Date empDOB, Date empJOD, Integer empAge, Double empBasic_Pay) {
		
		this.empName =empName;
		this.empDesignation =empDesignation;
		this.empDOB =empDOB;
		this.empJOD =empJOD;
		this.empAge =empAge;
		this.empBasic_Pay =empBasic_Pay;
	}
	
	/*Required columns are added with Hibernate-JPA annotation validation*/
	
	@Id
	@GeneratedValue
	@Column(name="empCode")
	public Integer getEmpCode() {
		return empCode;
	}
	public void setEmpCode(Integer empCode) {
		this.empCode = empCode;
	}
	
	@Column(name="empName")
	@Size(max = 20, min = 1, message = "Invalid Employee Name")
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName.toUpperCase();
	}
	
	@Column(name="empDesignation")
	@Pattern(regexp = "SE|SSE|SS|SSS", flags = Pattern.Flag.CASE_INSENSITIVE, message="Invalid Employee Designation, It should be either SE/SSE/SS/SSS ")
	public String getEmpDesignation() {
		return empDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
	
	@Column(name="empDOB")
	public Date getEmpDOB() {
		return empDOB;
	}
	public void setEmpDOB(Date empDOB) {
		this.empDOB = empDOB;
	}
	
	@Column(name="empJOD")
	public Date getEmpJOD() {
		return empJOD;
	}
	public void setEmpJOD(Date empJOD) {
		this.empJOD = empJOD;
	}
	
	@Column(name="empAge")
	@NotNull
	@Range(min = 18, max = 60, message = "Invalid Age")
	public Integer getEmpAge() {
		return empAge;
	}
	public void setEmpAge(Integer empAge) {
		this.empAge = empAge;
	}
	
	@Column(name="empBasic_Pay")
	@NotNull
	@Range(min = 6000, message = "Invalid Basic pay")
	public Double getEmpBasic_Pay() {
		return empBasic_Pay;
	}
	public void setEmpBasic_Pay(Double empBasic_Pay) {
		this.empBasic_Pay = empBasic_Pay;
	}
}
