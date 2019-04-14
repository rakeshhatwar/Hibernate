package hibernate.HibernateAssignment.topic1.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import hibernate.HibernateAssignment.topic1.entity.ProductEntity;
import hibernate.HibernateAssignment.util.HibernateUtil;

public class TopicOneAssignmentTwoManager {

	public static void main(String[] args) {
		
		List<ProductEntity> listOfproducts = getListOfEmployees();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
       
		//Add new Employee details into products table
		for(ProductEntity products: listOfproducts) {
			
			session.save(products);
		}
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}

	private static List<ProductEntity> getListOfEmployees() {
		
		List<ProductEntity> listOfProducts = new ArrayList<ProductEntity>();
		
		listOfProducts.add(new ProductEntity("Computers", 200000));
		listOfProducts.add(new ProductEntity("Keyboard", 10000));
		listOfProducts.add(new ProductEntity("Mouse", 200));
		listOfProducts.add(new ProductEntity("Mother board", 2000));
		listOfProducts.add(new ProductEntity("Processer", 300000));
		listOfProducts.add(new ProductEntity("Cabinate", 600));
		listOfProducts.add(new ProductEntity("Monitor", 20000));
		listOfProducts.add(new ProductEntity("Cooling fan", 9000));
		listOfProducts.add(new ProductEntity("Screen gard", 3000));
		listOfProducts.add(new ProductEntity("Mouse Pad", 300));
		
		return listOfProducts;
	}
	
	   /* Method to  READ all the employees */
	   public static void listEmployees(){
		   
		   Session session = HibernateUtil.getSessionFactory().openSession();
		   session.beginTransaction();
		   
	      try {

	    	 System.out.println("------ List of newly added Products -----"); 
	    	  
	    	 List<ProductEntity> products = session.createQuery("FROM ProductEntity").list();
	    	 
	         for (ProductEntity product: products){
	        	 
	        	 System.out.println("Product Id: " + product.getProductId()); 
	             System.out.print("  Product Name: " + product.getProductName()); 
	             System.out.print("  Product Price: " + product.getPrice());
	             System.out.println("\n------------------------------------------------\n");
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace(); 
	      } 
	   }
}
