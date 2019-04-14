package hibernate.HibernateAssignment.topic4.main;

import java.util.List;

import org.hibernate.Session;

import hibernate.HibernateAssignment.topic4.entity.Department;
import hibernate.HibernateAssignment.topic4.entity.Employee;
import hibernate.HibernateAssignment.util.HibernateUtil;

public class TopicFourAssignmentOneManager {

	public static void main(String[] args) {
		
	  Integer departmentId = 0;	

      
      Employee employee1 = new Employee();
      employee1.setName("Adam");
      employee1.setDesignation("Manager");

      Employee employee2 = new Employee();
      employee2.setName("Miller");
      employee2.setDesignation("Software Engineer");

      Employee employee3 = new Employee();
      employee3.setName("Smith");
      employee3.setDesignation("Associate  Engineer");

      Department department1 = new Department();
      department1.setDeptName("IT Department");
      department1.getEmployees().add(employee1);
      department1.getEmployees().add(employee2);
      department1.getEmployees().add(employee3);

      Employee employee4 = new Employee();
      employee4.setName("Adam");
      employee4.setDesignation("Manager");

      Employee employee5 = new Employee();
      employee5.setName("Miller");
      employee5.setDesignation("Software Engineer");

      Employee employee6 = new Employee();
      employee6.setName("Smith");
      employee6.setDesignation("Associate  Engineer");
      
      Department department2 = new Department();
      department2.setDeptName("Finance Department");
      department2.getEmployees().add(employee4);
      department2.getEmployees().add(employee5);
      department2.getEmployees().add(employee6);
      
      System.out.println("**************************************************************\n");
      System.out.println("\n");
      System.out.println("\n*********Saving Department and Employee details *********\n");
      
      // Save department1
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.save(department1);
	  session.getTransaction().commit();
	  session.close();
	  
	  // Save department2
	  session = HibernateUtil.getSessionFactory().openSession();
	  session.beginTransaction();
	  departmentId = (Integer) session.save(department2);
	  session.getTransaction().commit();
	  session.close();
	  
	  System.out.println("\n");
      System.out.println("\n*********List of Department and Employee details *********\n");
      listEmployees();
      
      System.out.println("\n");
      System.out.println("\n*********Deleting Department ID '"+departmentId+"' *********\n");
      
      deleteDepartment(departmentId);
      
      System.out.println("\n");
      System.out.println("\n*********List of Department and Employee details after deleting *********\n");
      listEmployees();
	}
	
   private static void deleteDepartment(Integer departmentId) {
	
	   Session session = HibernateUtil.getSessionFactory().openSession();
	   session.beginTransaction();
	   
	   Department department = (Department) session.get(Department.class,departmentId);
	   
	   // Deleting department and employee details
	   session.delete(department);
	   
	   session.getTransaction().commit();
	   session.close();
	   
	   System.out.println("\n Deleted Department and Employees object successfully\\n ");
   }

/* Method to  READ all the Department and Employees */
   public static void listEmployees(){
	   
	   Session session = HibernateUtil.getSessionFactory().openSession();
	   session.beginTransaction();
	   
      try {

    	 System.out.println("------ List of newly added Employees -----"); 
    	  
    	 List<Department> departmentList = session.createQuery("FROM Department").list();
    	 
         for (Department department: departmentList){
        	 
        	 System.out.println("Department Name: " + department.getDeptName()+" Department Id:"+ department.getId()+" \n");
        	 
        	 for(Employee employee:department.getEmployees()) {
        		 
        		 System.out.print("  Employee ID: " + employee.getId());
            	 System.out.print("  Employee Name: " + employee.getName()); 
                 System.out.print("  Employee Designation: " + employee.getDesignation());
                 System.out.println("\n------------------------------------------------\n");
        	 }
        	 System.out.println("**************************************************************\n");
         }
         
      } catch (Exception e) {
         e.printStackTrace(); 
      } 
   }
}
