package hibernate.HibernateAssignment.topic3.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class MultiOptions {

	private String options;
	
	public MultiOptions() {
		
	}
	
	public MultiOptions(String options) {
		this.options = options;
	}

	@NotNull
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
}
