package hibernate.HibernateAssignment.topic4.main;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import hibernate.HibernateAssignment.topic4.entity.Course;
import hibernate.HibernateAssignment.topic4.entity.Student;
import hibernate.HibernateAssignment.util.HibernateUtil;

public class TopicFourAssignmentThreeManager {

	public static void main(String[] args) {
		
      System.out.println("**************************************************************\n");
      System.out.println("\n");
      System.out.println("\n*********Saving Student and Course details *********\n");
      
      // Save Student and Course details
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();

	  Set<Course> courses = new HashSet<Course>();
	  courses.add(new Course("Maths"));
	  courses.add(new Course("Computer Science"));
	  courses.add(new Course("Science"));
	
	  Student student1 = new Student("Eswar", courses);
	  Student student2 = new Student("Joe", courses);
	  session.save(student1);
	  session.save(student2);
      
      session.getTransaction().commit();
	  session.close();
	  
	  System.out.println("\n");
      System.out.println("\n*********List of Student and Course details *********\n");
      
      listStudentDetails();
	}

    /* Method to  READ all the Student details*/
   public static void listStudentDetails(){
	   
	   Session session = HibernateUtil.getSessionFactory().openSession();
	   session.beginTransaction();
	   
      try {

    	 System.out.println("------ List of newly added Students -----"); 
    	  
    	 List<Student> studentList = session.createQuery("FROM Student").list();
    	 
         for (Student student: studentList){
        	 
        	 System.out.println("Student Name: " + student.getStudentName()+" Student Id: "+ student.getStudentId()+" \n");
        	 
        	 for(Course course: student.getCourses()) {
        		 
        		 System.out.print("  Course ID: " + course.getCourseId());
            	 System.out.print("  Course Name: " + course.getCourseName()); 
            	 System.out.println("\n");
        	 }
        	 
        	 System.out.println("\n**************************************************************\n");
         }
         
      } catch (Exception e) {
         e.printStackTrace(); 
      } 
   }
}
