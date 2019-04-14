package hibernate.HibernateAssignment.topic3.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Country {

	private String countryName;
	
	public Country() {
		
	}
	
	public Country(String countryName) {
		
		this.countryName = countryName;
	}

	@NotNull
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
}
