package hibernate.HibernateAssignment.topic6.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeTopic6_Assignment1")
@Inheritance(strategy=InheritanceType.JOINED)  
public class EmployeeTopic6_Ass1 {

	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)  
	@Column(name = "employeeID")  
	private Integer employeeID;  
	  
	@Column(name = "employeeName")  
	private String employeeName;  
	
	@Column(name = "employeeSalary")
	private double employeeSalary;

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
}
