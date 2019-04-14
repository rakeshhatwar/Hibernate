package hibernate.HibernateAssignment.topic6.main;

import org.hibernate.Session;

import hibernate.HibernateAssignment.topic6.entity.ContractEmployee6_Ass1;
import hibernate.HibernateAssignment.topic6.entity.EmployeeTopic6_Ass1;
import hibernate.HibernateAssignment.topic6.entity.RegularEmployee6_Ass1;
import hibernate.HibernateAssignment.util.HibernateUtil;

public class TopicSixAssignmentOneManager {

	public static void main(String[] args) {
		
	  // Add employee details
	  System.out.println("\n------ Saving the details of Regular and Contract Employees ------ \n");
	  
	  EmployeeTopic6_Ass1 employeeDetails1 = new EmployeeTopic6_Ass1();
	  employeeDetails1.setEmployeeName("Rakesh");
	  employeeDetails1.setEmployeeSalary(10000);
	  
	  // Regular Employee
	  RegularEmployee6_Ass1 regularEmployee1 = new RegularEmployee6_Ass1();
	  regularEmployee1.setEmployeeName("Radha");
	  regularEmployee1.setEmployeeSalary(12000);
	  regularEmployee1.setQplc(60.0);
	  
	  // Contract employee
	  ContractEmployee6_Ass1 contractEmployee1 = new ContractEmployee6_Ass1();
	  contractEmployee1.setEmployeeName("Balakrishna");
	  contractEmployee1.setEmployeeSalary(16000);
	  contractEmployee1.setAllowance(10.30);
	  
	  Session session = HibernateUtil.getSessionFactory().openSession();
	  session.beginTransaction();
	   
	  session.save(employeeDetails1);
	  session.save(regularEmployee1);
	  session.save(contractEmployee1);
	   
	  session.getTransaction().commit();
	  
	  // Deleting regular employee details
      deleteRegularEmployeeDetails(regularEmployee1.getEmployeeID());
	}

    /* Method to  READ all Employee details */
	private static void deleteRegularEmployeeDetails(Integer employeeId){
	   
	   Session session = HibernateUtil.getSessionFactory().openSession();
	   session.beginTransaction();
	   
      try {

    	 System.out.println("------ Deleting Regular Employee -----"); 
    	  
    	 RegularEmployee6_Ass1 employee = (RegularEmployee6_Ass1)session.get(RegularEmployee6_Ass1.class, employeeId);
    	 
    	 session.delete(employee);
    	 session.getTransaction().commit();
         
      } catch (Exception e) {
         e.printStackTrace(); 
      } 
   }
}
