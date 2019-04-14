package hibernate.HibernateAssignment.topic6.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity  
@DiscriminatorValue("regularemployee")   
public class RegularEmployee6_Ass2 extends EmployeeTopic6_Ass2{

	@Column(name="bonus")
	private double qplc;

	public double getQplc() {
		return qplc;
	}

	public void setQplc(double qplc) {
		this.qplc = qplc;
	}
}
