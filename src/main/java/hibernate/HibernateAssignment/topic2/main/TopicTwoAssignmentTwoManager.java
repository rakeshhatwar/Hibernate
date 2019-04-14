package hibernate.HibernateAssignment.topic2.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.Session;

import hibernate.HibernateAssignment.topic2.entity.ABCCompanyEmployeeEntity;
import hibernate.HibernateAssignment.topic2.entity.EmployeeLogTabEntity;
import hibernate.HibernateAssignment.util.HibernateUtil;

public class TopicTwoAssignmentTwoManager {

	public static void main(String[] args) {

		Integer recentlyAddedEmployeeId = 0;
		
		List<ABCCompanyEmployeeEntity> listOfEmployees = getListOfABCCompanyEmployees();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
       
		/* Use case 1: Add ABC Company Employee details into ABC_EMPLOYEE_DETAILS table */
		
		// Note: Validating employee details are handled through JPA validation on entity class
		for(ABCCompanyEmployeeEntity employee: listOfEmployees) {
			
			/* Use case 2:  Validate before saving employee details */
			if(isValidEmployeeDetails(employee)) {
				
				recentlyAddedEmployeeId = (Integer) session.save(employee);
			}
		}
		
		session.getTransaction().commit();
		
		/*List of newly added ABC Company employees*/
		listEmployees();
		
		/* Use case 3: Delete Employee details from ABC_EMPLOYEE_DETAILS table and save it in employeeLogTab table*/
	    System.out.println("\n*********Deleting Employee '"+recentlyAddedEmployeeId+"' Details*********\n");
        deleteEmployee(recentlyAddedEmployeeId);
        System.out.println("**************************************************************\n");
        System.out.println("\n");
        
        
		/*List of deleted employee details*/
        getEmployeeLogDetails();
	}

	private static void getEmployeeLogDetails() {
		   
		  Session session = HibernateUtil.getSessionFactory().openSession();
		  session.beginTransaction();
		   
	      try {

	    	 System.out.println("------ List of Employees left the Organization-----"); 
	    	  
	    	 List<EmployeeLogTabEntity> employees = session.createQuery("FROM EmployeeLogTabEntity").list();
	    	 
	         for (EmployeeLogTabEntity employee: employees){
	        	 
	        	 System.out.println("Employee Id: " + employee.getEmpCode()); 
	             System.out.print("  Name: " + employee.getEmpName()); 
	             System.out.print("  Designation: " + employee.getEmpDesignation());
	             System.out.print("  Basic Pay: " + employee.getLastDrawnSalary());
	             System.out.print("  Employee Leaving Date: " + convertDateObjectToString(employee.getLeavingDate()));
	             System.out.println("\n------------------------------------------------\n");
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace(); 
	      } 
	   }

	private static boolean isValidEmployeeDetails(ABCCompanyEmployeeEntity employee) {
		
		//Create ValidatorFactory which returns validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
         
        //It validates bean instances
        Validator validator = factory.getValidator();
 
        //Validate bean
        Set<ConstraintViolation<ABCCompanyEmployeeEntity>> constraintViolations = validator.validate(employee);
 
        //Show errors
        if (constraintViolations.size() > 0) {
            
        	for (ConstraintViolation<ABCCompanyEmployeeEntity> violation : constraintViolations) {
                System.out.println(violation.getMessage()+". Enter Valid Information for "+employee.getEmpName());
            }
        	
        } else {
        	
            return true; // If valid Employee details
        }
		
		return false;
	}

	private static List<ABCCompanyEmployeeEntity> getListOfABCCompanyEmployees(){
		
		List<ABCCompanyEmployeeEntity> listOfEmployees = new ArrayList<ABCCompanyEmployeeEntity>();
		
		listOfEmployees.add(new ABCCompanyEmployeeEntity("Rakesh", "SS", getDateObject("20/05/1988"), new Date(), 31, 15000.0));
		listOfEmployees.add(new ABCCompanyEmployeeEntity("Radha", "SSS", getDateObject("16/06/1966"), new Date(), 45, 52323.0));
		listOfEmployees.add(new ABCCompanyEmployeeEntity("Balakrishna", "SE", getDateObject("14/02/1990"), new Date(), 30, 32333.0));
		listOfEmployees.add(new ABCCompanyEmployeeEntity("Santosh", "SSE", getDateObject("12/03/1992"), new Date(), 28, 23452.0));
		listOfEmployees.add(new ABCCompanyEmployeeEntity("Sriraj", "SE", getDateObject("30/09/1991"), new Date(), 26, 1443.0));
		
		return listOfEmployees;
	}
	
   /* Method to  READ all the employees */
   public static void listEmployees(){
	   
	   Session session = HibernateUtil.getSessionFactory().openSession();
	   session.beginTransaction();
	   
      try {

    	 System.out.println("------ List of newly added Employees -----"); 
    	  
    	 List<ABCCompanyEmployeeEntity> employees = session.createQuery("FROM ABCCompanyEmployeeEntity").list();
    	 
         for (ABCCompanyEmployeeEntity employee: employees){
        	 
        	 System.out.println("Employee Id: " + employee.getEmpCode()); 
             System.out.print("  Name: " + employee.getEmpName()); 
             System.out.print("  Designation: " + employee.getEmpDesignation());
             System.out.print("  Basic Pay: " + employee.getEmpBasic_Pay());
             System.out.print("  Age: " + employee.getEmpAge());
             System.out.print("  DOB: " + convertDateObjectToString(employee.getEmpDOB()));
             System.out.print("  JOD: " + convertDateObjectToString(employee.getEmpJOD()));
             System.out.println("\n------------------------------------------------\n");
         }
         
      } catch (Exception e) {
         e.printStackTrace(); 
      } 
   }
   
   public static Date getDateObject(String stringDate){
	    Date dateObject = null;
	    try {
	    	
	    	dateObject = new SimpleDateFormat("MM/dd/yyyy").parse(stringDate);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    
	    return dateObject;
   }
   
   public static String convertDateObjectToString(Date dateObj){
	    return new SimpleDateFormat("MM/dd/yyyy").format(dateObj);
   }
   
   /* Method to DELETE an employee from the records */
   public static void deleteEmployee(Integer employeeID){
	  
	   Session session = HibernateUtil.getSessionFactory().openSession();
	   session.beginTransaction();
	   
      try {
    	  
    	  ABCCompanyEmployeeEntity employee = (ABCCompanyEmployeeEntity)session.get(ABCCompanyEmployeeEntity.class, employeeID); 
    	  
    	  // Save employee details in employeeLogTab
    	  addEmployee(employee);

    	  // Deleting employee details
    	  session.delete(employee); 
         
       } catch (Exception e) {
          e.printStackTrace(); 
	   }
   }
   
	 /* Method to CREATE an employeeLogTab in database */
   public static void addEmployee(ABCCompanyEmployeeEntity employee){
	   
	  System.out.println("\n*********Adding '"+employee.getEmpCode()+"' Employee Details into employeeLogTab table*********\n");
	  Session session = HibernateUtil.getSessionFactory().openSession();
	  session.beginTransaction();
      
      try {
    	  
    	  EmployeeLogTabEntity employeeLogTabEntity = new EmployeeLogTabEntity();
    	  employeeLogTabEntity.setEmpCode(employee.getEmpCode());
    	  employeeLogTabEntity.setEmpDesignation(employee.getEmpDesignation());
    	  employeeLogTabEntity.setEmpName(employee.getEmpName());
    	  employeeLogTabEntity.setLastDrawnSalary(employee.getEmpBasic_Pay());
    	  employeeLogTabEntity.setLeavingDate(new Date());
    	  
          session.save(employeeLogTabEntity); 
          session.getTransaction().commit();
          
      } catch (Exception e) {
         e.printStackTrace(); 
      } 
   }
}
