package hibernate.HibernateAssignment.topic6.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity  
@Table(name="ContractEmployee_topic6_Assignment3")  
@AttributeOverrides({  
    @AttributeOverride(name="employeeID", column=@Column(name="employeeID")),  
    @AttributeOverride(name="employeeName", column=@Column(name="naemployeeNameme"))
})    
public class ContractEmployee6_Ass3 extends EmployeeTopic6_Ass3{

	@Column(name="allowance")
	private double allowance;

	public double getAllowance() {
		return allowance;
	}

	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}
}
