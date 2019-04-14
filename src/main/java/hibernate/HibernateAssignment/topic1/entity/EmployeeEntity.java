package hibernate.HibernateAssignment.topic1.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "TOPIC_1_EMPLOYEE_DETAILS", uniqueConstraints = @UniqueConstraint(columnNames = "empId"))
public class EmployeeEntity implements Serializable {
	
	private static final long serialVersionUID = -1798070786993154676L;
	
	public EmployeeEntity() {
		
	}
	
    public EmployeeEntity(String name,String designation, Integer salary) {
        this.name = name;
        this.salary = salary;
        this.designation = designation;
    }
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmpId", unique = true, nullable = false)
	private Integer empId;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Designation")
	private String designation;
	
	@Column(name = "Salary")
	private Integer salary;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
