package hibernate.HibernateAssignment.topic2.main;

import java.util.List;

import org.hibernate.Session;

import hibernate.HibernateAssignment.topic2.entity.EmployeeManagementEntity;
import hibernate.HibernateAssignment.util.HibernateUtil;

public class TopicTwoAssignmentOneManager {

	public static void main(String[] args) {
		
	  TopicTwoAssignmentOneManager assignment = new TopicTwoAssignmentOneManager();

      /* Add few employee records in database */ // 
      Integer empID1 = assignment.addEmployee("Rakesh", "Level 4");
      Integer empID2 = assignment.addEmployee("Radha", "Level 5");
      Integer empID3 = assignment.addEmployee("Balakrishna", "Level 6");
      Integer empID4 = assignment.addEmployee("Santosh", "Level 1");
      System.out.println("**************************************************************\n");
      System.out.println("\n");
      
      /* List down all the employees */
      System.out.println("\n*********List of Employee *********\n");
      assignment.listEmployees();
      System.out.println("**************************************************************\n");
      System.out.println("\n");

      
      /* Update employee's records */
      System.out.println("\n*********Updating Employee '"+empID3+"' Details*********\n");
      assignment.updateEmployee(empID3, "Balakrishna Hatwar", "Level 8");
      System.out.println("**************************************************************\n");
      System.out.println("\n");

      /* Delete an employee from the database */
      System.out.println("\n*********Deleting Employee '"+empID4+"' Details*********\n");
      assignment.deleteEmployee(empID4);
      System.out.println("**************************************************************\n");
      System.out.println("\n");

      /* List down new list of the employees */
      System.out.println("\n*********List of Employee *********\n");
      assignment.listEmployees();
      System.out.println("**************************************************************\n");
      System.out.println("\n");
	}
	
	 /* Method to CREATE an employee in the database */
   public Integer addEmployee(String employeeName, String employeeBand){
	   
	   System.out.println("\n*********Adding new Employee Details*********\n");
	   Session session = HibernateUtil.getSessionFactory().openSession();
	   session.beginTransaction();
       Integer employeeID = null;
      
      try {
    	  
    	  EmployeeManagementEntity employee = new EmployeeManagementEntity(employeeName, employeeBand);
          employeeID = (Integer) session.save(employee); 
          session.getTransaction().commit();
          
      } catch (Exception e) {
         e.printStackTrace(); 
      } 
      
      return employeeID;
   }
   
   /* Method to  READ all the employees */
   public void listEmployees( ){
	   
	   Session session = HibernateUtil.getSessionFactory().openSession();
	   session.beginTransaction();
	   
      try {

    	 List<EmployeeManagementEntity> employees = session.createQuery("FROM EmployeeManagementEntity").list();
    	 
         for (EmployeeManagementEntity employee: employees){
        	 
        	 System.out.println("Employee Id: " + employee.getEmployeeId()); 
             System.out.print("  Employee Name: " + employee.getEmployeeName()); 
             System.out.print("  Employee Band: " + employee.getEmployeeBand()); 
             System.out.println("\n------------------------------------------------\n");
         }
         
      } catch (Exception e) {
         e.printStackTrace(); 
      } 
   }
   
   /* Method to UPDATE salary for an employee */
   public void updateEmployee(Integer employeeID, String employeeName, String employeeBand ){

	   Session session = HibernateUtil.getSessionFactory().openSession();
	   session.beginTransaction();
	   
      try {

    	  EmployeeManagementEntity employee = (EmployeeManagementEntity)session.get(EmployeeManagementEntity.class, employeeID); 
          employee.setEmployeeBand(employeeBand);
          employee.setEmployeeName(employeeName);
		  session.update(employee); 
		  
       } catch (Exception e) {
          e.printStackTrace(); 
	   } 
   }
   
   /* Method to DELETE an employee from the records */
   public void deleteEmployee(Integer employeeID){
	  
	   Session session = HibernateUtil.getSessionFactory().openSession();
	   session.beginTransaction();
	   
      try {
    	  
    	  EmployeeManagementEntity employee = (EmployeeManagementEntity)session.get(EmployeeManagementEntity.class, employeeID);  
          session.delete(employee); 
         
       } catch (Exception e) {
          e.printStackTrace(); 
	   }
   }
}
