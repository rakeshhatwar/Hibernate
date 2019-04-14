package hibernate.HibernateAssignment.topic4.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Employee_Identity")
public class EmployeeIdentity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmpId", unique = true, nullable = false)
	private Integer empId;
	
	@Column(name = "Name")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Passport passport;

	public EmployeeIdentity() {
		
	}
	
	public EmployeeIdentity(String name,Passport passport) {
		
		this.name = name;
		this.passport = passport;
	}
	
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

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}
}
