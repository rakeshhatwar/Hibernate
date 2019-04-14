package hibernate.HibernateAssignment.topic2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_MANAGEMENT")
public class EmployeeManagementEntity {

	private Integer employeeId;
	private String employeeName;
	private String employeeBand;
	
	public EmployeeManagementEntity() {
		
	}
	
	public EmployeeManagementEntity(String employeeName,String employeeBand) {
		
		this.employeeName = employeeName;
		this.employeeBand = employeeBand;
	}
	
	@Id
	@GeneratedValue
	@Column(name="employee_Id")
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
	@Column(name="employeeName")
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	@Column(name="employeeBand")
	public String getEmployeeBand() {
		return employeeBand;
	}
	public void setEmployeeBand(String employeeBand) {
		this.employeeBand = employeeBand;
	}
}
