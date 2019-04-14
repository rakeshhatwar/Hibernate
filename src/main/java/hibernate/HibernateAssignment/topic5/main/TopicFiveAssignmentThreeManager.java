package hibernate.HibernateAssignment.topic5.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import hibernate.HibernateAssignment.topic5.entity.Car;
import hibernate.HibernateAssignment.util.HibernateUtil;

public class TopicFiveAssignmentThreeManager {

	public static void main(String[] args) {
		
	  // Check for the Car table and its values, If values are not present then insert new values
	  createAndInsertValuesForCar();
	  
	  // Car details which the registration Number
	  
	  String regNo = "";
	  boolean exitStatus = true;
	  Scanner scanner = null;
	  
	  try {
		
		  do {
			  
			  System.out.println("Please enter Car registration number or type 'exit' to stop the program \n");
			  scanner = new Scanner(System.in);
			  regNo = scanner.nextLine();
			  
			  if(regNo.equalsIgnoreCase("exit")) {
				  
				  exitStatus = false;
				  System.out.println(" Program terminated \n");
			  } else {
				  
				  listCarDetailsBasedOnRegNumber(regNo);
			  }
			  
		  }while(exitStatus);
		  
	} finally {
		
		scanner.close();
	}
	  
      
	}
	

	private static void createAndInsertValuesForCar() {
		
		try {
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			List<Car> carList = session.createQuery("FROM Car").list();
			
			if(carList!= null && carList.isEmpty()) {
				
				createCarDetails();
			}
			
		} catch (Exception e) {
			
			// Handled exception
			createCarDetails();
		}
	}


   private static void createCarDetails() {
		
	   Car car1 = new Car("KL-07 AB 123","Polo","White", "Volkswagen",700000);
	   Car car2 = new Car("KL-07 AB 234","Vento","Black", "Volkswagen",600000);
	   Car car3 = new Car("KL-07 AC 345","Corolla","Silver", "Toyota",1000000);
	   Car car4 = new Car("KL-07 BC 123","Sail Uva","Red", "Chevrolet",500000);
	   
	   Session session = HibernateUtil.getSessionFactory().openSession();
	   session.beginTransaction();
	   
	   session.save(car1);
	   session.save(car2);
	   session.save(car3);
	   session.save(car4);
	   
	   session.getTransaction().commit();
   }


/* Method to  READ all Car details */
	private static void listCarDetailsBasedOnRegNumber(String regNo){
	   
	   Session session = HibernateUtil.getSessionFactory().openSession();
	   session.beginTransaction();
	   
      try {

    	 System.out.println("------ Car details which the registration Number '"+regNo+"' -----"); 
    	  
    	 Criteria criteria = session.createCriteria(Car.class);
    	 criteria.add(Restrictions.eq("regNo", regNo));
    	 List<Car> carList = criteria.list();
    	 
         for (Car car: carList){
        	 
        	 System.out.println("\n Car RegNo:"+ car.getRegNo()+" \n");
        		 
        	 System.out.print("  Car Model: " + car.getModel()); 
        	 System.out.print("  Car Color: " + car.getColor()); 
        	 System.out.print("  Car Manufacturer: " + car.getManufacturer()); 
        	 System.out.print("  Car Price: " + car.getPrice()); 
                 
        	 System.out.println("\n**************************************************************\n");
         }
         
      } catch (Exception e) {
         e.printStackTrace(); 
      } 
   }
}
