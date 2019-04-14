package hibernate.HibernateAssignment.topic4.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Passport")
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer passportId;
	
	@Column(name = "permited_country")
	private String permitedCountry;

	public Passport() {
		
	}
	
	public Passport(String permitedCountry) {
		this.permitedCountry = permitedCountry;
	}
	
	public Integer getPassportId() {
		return passportId;
	}

	public void setPassportId(Integer passportId) {
		this.passportId = passportId;
	}

	public String getPermitedCountry() {
		return permitedCountry;
	}

	public void setPermitedCountry(String permitedCountry) {
		this.permitedCountry = permitedCountry;
	}
}
