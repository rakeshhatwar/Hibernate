package hibernate.HibernateAssignment.topic5.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CAR_DETAILS")
public class Car {

	@Id
	@Column(name="RegNo")
	private String regNo;
	
	@Column(name="Model")
	private String model;
	
	@Column(name="Color")
	private String color;
	
	@Column(name="Manufacturer")
	private String manufacturer;
	
	@Column(name="Price")
	private Integer price;
	
	public Car() {
		
	}
	
	public Car(String regNo,String model,String color, String manufacturer,Integer price) {
		
		this.regNo = regNo;
		this.model = model;
		this.color = color;
		this.manufacturer = manufacturer;
		this.price = price;
	}
	
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
}
