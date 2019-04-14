package hibernate.HibernateAssignment.topic1.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import hibernate.HibernateAssignment.topic1.entity.EmployeeEntity;
import hibernate.HibernateAssignment.util.HibernateUtil;

public class TopicOneAssignmentOneManager {

	public static void main(String[] args) {
		
		List<EmployeeEntity> listOfEmployees = getListOfEmployees();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
       
		//Add new Employee details into employee table
		for(EmployeeEntity employee: listOfEmployees) {
			
			session.save(employee);
		}
		
		session.getTransaction().commit();
		
		/*List of added employees*/
		listEmployees();
	}

	private static List<EmployeeEntity> getListOfEmployees() {
		
		List<EmployeeEntity> listOfEmployees = new ArrayList<EmployeeEntity>();
		
		listOfEmployees.add(new EmployeeEntity("Rakesh", "Senior Engineer", 200000));
		listOfEmployees.add(new EmployeeEntity("Radha", "Engineer", 10000));
		listOfEmployees.add(new EmployeeEntity("Rajesh", "Senior Engineer", 1000));
		listOfEmployees.add(new EmployeeEntity("Balakrishna", "Team lead", 500000));
		listOfEmployees.add(new EmployeeEntity("Santosh", "Engineer", 2000));
		
		return listOfEmployees;
	}
	
   /* Method to  READ all the employees */
   public static void listEmployees(){
	   
	   Session session = HibernateUtil.getSessionFactory().openSession();
	   session.beginTransaction();
	   
      try {

    	 System.out.println("------ List of newly added Employees -----"); 
    	  
    	 List<EmployeeEntity> employees = session.createQuery("FROM EmployeeEntity").list();
    	 
         for (EmployeeEntity employee: employees){
        	 
        	 System.out.println("Employee Id: " + employee.getEmpId()); 
             System.out.print("  Employee Name: " + employee.getName()); 
             System.out.print("  Employee Designation: " + employee.getDesignation());
             System.out.print("  Employee Salary: " + employee.getSalary());
             System.out.println("\n------------------------------------------------\n");
         }
         
      } catch (Exception e) {
         e.printStackTrace(); 
      } 
   }
}
