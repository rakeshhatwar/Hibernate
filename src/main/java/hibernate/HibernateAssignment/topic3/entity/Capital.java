package hibernate.HibernateAssignment.topic3.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Capital {

	private String capitalName;
	
	public Capital() {
		
	}
	
	public Capital(String capitalName) {
		
		this.capitalName = capitalName;
	}

	@NotNull
	public String getCapitalName() {
		return capitalName;
	}

	public void setCapitalName(String capitalName) {
		this.capitalName = capitalName;
	}
}
