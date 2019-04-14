package hibernate.HibernateAssignment.topic6.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity  
@DiscriminatorValue("contractemployee") 
public class ContractEmployee6_Ass2 extends EmployeeTopic6_Ass2{

	@Column(name="allowance")
	private double allowance;

	public double getAllowance() {
		return allowance;
	}

	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}
}
