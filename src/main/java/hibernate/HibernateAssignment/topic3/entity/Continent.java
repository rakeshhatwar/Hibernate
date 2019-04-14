package hibernate.HibernateAssignment.topic3.entity;

import java.util.Map;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Continent")
public class Continent {

	@Id
    @GeneratedValue
    private int id;
	
	@Column(name="cname")
    private String cname;
    
	@ElementCollection
    @AttributeOverrides({
        @AttributeOverride(name="key.countryName", column=@Column(name="countryName")),
        @AttributeOverride(name="value.capitalName", column=@Column(name="capitalName"))
     })
    private Map<Country, Capital> countries;

	public Continent(String cname,Map<Country, Capital> countries) {
		
		this.cname = cname;
		this.countries = countries;
	}
	
	public Continent() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Map<Country, Capital> getCountries() {
		return countries;
	}

	public void setCountries(Map<Country, Capital> countries) {
		this.countries = countries;
	}
}
