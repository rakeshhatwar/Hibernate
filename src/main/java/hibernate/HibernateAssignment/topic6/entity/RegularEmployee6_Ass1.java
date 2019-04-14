package hibernate.HibernateAssignment.topic6.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity  
@Table(name="regularemployee6_Ass1")  
@PrimaryKeyJoinColumn(name="employeeID")  
public class RegularEmployee6_Ass1 extends EmployeeTopic6_Ass1{

	@Column(name="bonus")
	private double qplc;

	public double getQplc() {
		return qplc;
	}

	public void setQplc(double qplc) {
		this.qplc = qplc;
	}
}
