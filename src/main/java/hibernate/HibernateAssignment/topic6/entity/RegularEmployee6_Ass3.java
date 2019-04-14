package hibernate.HibernateAssignment.topic6.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity  
@Table(name="RegularEmployee_topic6_Assignment3")  
@AttributeOverrides({  
    @AttributeOverride(name="employeeID", column=@Column(name="employeeID")),  
    @AttributeOverride(name="employeeName", column=@Column(name="naemployeeNameme"))
})  
public class RegularEmployee6_Ass3 extends EmployeeTopic6_Ass3{

	@Column(name="bonus")
	private double qplc;

	public double getQplc() {
		return qplc;
	}

	public void setQplc(double qplc) {
		this.qplc = qplc;
	}
}
