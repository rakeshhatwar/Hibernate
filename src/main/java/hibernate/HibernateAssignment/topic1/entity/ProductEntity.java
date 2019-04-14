package hibernate.HibernateAssignment.topic1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="PRODUCT")
public class ProductEntity {

	private String productName;
	private Integer productId;
	private Integer price;
	
    public ProductEntity(String productName,Integer price) {
        this.productName = productName;
        this.price = price;
    }
	
	@Id
	/*@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
            @org.hibernate.annotations.Parameter(name = "sequenceName", value = "sequence"),
            @org.hibernate.annotations.Parameter(name = "allocationSize", value = "1"),
    })*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productId", unique = true, nullable = false)
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	@Column(name = "ProductName", unique = true, nullable = false)
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Column(name = "Price", unique = true, nullable = false)
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
}
