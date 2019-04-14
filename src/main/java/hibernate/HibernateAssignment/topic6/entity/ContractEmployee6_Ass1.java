package hibernate.HibernateAssignment.topic6.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity  
@Table(name="contractmployee6_Ass1")  
@PrimaryKeyJoinColumn(name="employeeID")  
public class ContractEmployee6_Ass1 extends EmployeeTopic6_Ass1{

	@Column(name="allowance")
	private double allowance;

	public double getAllowance() {
		return allowance;
	}

	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}
}
