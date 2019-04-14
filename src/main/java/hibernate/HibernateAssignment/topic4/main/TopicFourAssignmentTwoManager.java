package hibernate.HibernateAssignment.topic4.main;

import java.util.List;

import org.hibernate.Session;

import hibernate.HibernateAssignment.topic4.entity.EmployeeIdentity;
import hibernate.HibernateAssignment.topic4.entity.Passport;
import hibernate.HibernateAssignment.util.HibernateUtil;

public class TopicFourAssignmentTwoManager {

	public static void main(String[] args) {
		
	  Integer employeeId = 0;	
      
	  Passport passport1 = new Passport("India");
	  Passport passport2 = new Passport("US");
	  
	  EmployeeIdentity employee1 = new EmployeeIdentity("Rakesh",passport1);
	  EmployeeIdentity employee2 = new EmployeeIdentity("Radha",passport2);
      
      System.out.println("**************************************************************\n");
      System.out.println("\n");
      System.out.println("\n*********Saving Employee and Passport details *********\n");
      
      // Save employee1
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.save(employee1);
	  session.getTransaction().commit();
	  session.close();
	  
	  // Save employee2
	  session = HibernateUtil.getSessionFactory().openSession();
	  session.beginTransaction();
	  employeeId = (Integer) session.save(employee2);
	  session.getTransaction().commit();
	  session.close();
	  
	  System.out.println("\n");
      System.out.println("\n*********List of Employee and Passport details *********\n");
      listEmployees();
      
      System.out.println("\n");
      System.out.println("\n*********Deleting Employee details using ID '"+employeeId+"' *********\n");
      
      deleteEmployee(employeeId);
      
      System.out.println("\n");
      System.out.println("\n*********List of Employee and Employee Passport after deleting *********\n");
      listEmployees();
	}
	
   private static void deleteEmployee(Integer employeeId) {
	
	   Session session = HibernateUtil.getSessionFactory().openSession();
	   session.beginTransaction();
	   
	   EmployeeIdentity employee = (EmployeeIdentity) session.get(EmployeeIdentity.class,employeeId);
	   
	   // Deleting Passport and employee details
	   session.delete(employee);
	   
	   session.getTransaction().commit();
	   session.close();
	   
	   System.out.println("\n Deleted Department and Employees object successfully\\n ");
   }

/* Method to  READ all the Employee details*/
   public static void listEmployees(){
	   
	   Session session = HibernateUtil.getSessionFactory().openSession();
	   session.beginTransaction();
	   
      try {

    	 System.out.println("------ List of newly added Employees -----"); 
    	  
    	 List<EmployeeIdentity> employeeList = session.createQuery("FROM EmployeeIdentity").list();
    	 
         for (EmployeeIdentity employee: employeeList){
        	 
        	 System.out.println("Employee Name: " + employee.getName()+" Employee Id: "+ employee.getEmpId()+" \n");
        	 
    		 System.out.print("  Passport ID: " + employee.getPassport().getPassportId());
        	 System.out.print("  Permited Country Name: " + employee.getPassport().getPermitedCountry()); 
                 
        	 System.out.println("\n**************************************************************\n");
         }
         
      } catch (Exception e) {
         e.printStackTrace(); 
      } 
   }
}
