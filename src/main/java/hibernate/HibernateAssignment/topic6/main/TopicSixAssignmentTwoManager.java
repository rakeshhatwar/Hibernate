package hibernate.HibernateAssignment.topic6.main;

import org.hibernate.Session;

import hibernate.HibernateAssignment.topic6.entity.ContractEmployee6_Ass2;
import hibernate.HibernateAssignment.topic6.entity.EmployeeTopic6_Ass2;
import hibernate.HibernateAssignment.topic6.entity.RegularEmployee6_Ass2;
import hibernate.HibernateAssignment.util.HibernateUtil;

public class TopicSixAssignmentTwoManager {

	public static void main(String[] args) {
		
	  // Add employee details
	  System.out.println("\n------ Saving the details of Regular and Contract Employees ------ \n");
	  
	  EmployeeTopic6_Ass2 employeeDetails1 = new EmployeeTopic6_Ass2();
	  employeeDetails1.setEmployeeName("Rakesh");
	  employeeDetails1.setEmployeeSalary(10000);
	  
	  // Regular Employee
	  RegularEmployee6_Ass2 regularEmployee1 = new RegularEmployee6_Ass2();
	  regularEmployee1.setEmployeeName("Radha");
	  regularEmployee1.setEmployeeSalary(12000);
	  regularEmployee1.setQplc(60.0);
	  
	  RegularEmployee6_Ass2 regularEmployee2 = new RegularEmployee6_Ass2();
	  regularEmployee2.setEmployeeName("Ramesh");
	  regularEmployee2.setEmployeeSalary(100);
	  regularEmployee2.setQplc(10.0);
	  
	  // Contract employee
	  ContractEmployee6_Ass2 contractEmployee1 = new ContractEmployee6_Ass2();
	  contractEmployee1.setEmployeeName("Balakrishna");
	  contractEmployee1.setEmployeeSalary(16000);
	  contractEmployee1.setAllowance(10.30);
	  
	  ContractEmployee6_Ass2 contractEmployee2 = new ContractEmployee6_Ass2();
	  contractEmployee2.setEmployeeName("Rajesh");
	  contractEmployee2.setEmployeeSalary(18000);
	  contractEmployee2.setAllowance(18.30);
	  
	  Session session = HibernateUtil.getSessionFactory().openSession();
	  session.beginTransaction();
	   
	  //Save employees details
	  session.save(employeeDetails1);
	  session.save(regularEmployee1);
	  session.save(contractEmployee1);
	  session.save(regularEmployee2);
	  session.save(contractEmployee2);
	   
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
    	  
    	 RegularEmployee6_Ass2 employee = (RegularEmployee6_Ass2)session.get(RegularEmployee6_Ass2.class, employeeId);
    	 
    	 session.delete(employee);
    	 session.getTransaction().commit();
         
      } catch (Exception e) {
         e.printStackTrace(); 
      } 
   }
}
