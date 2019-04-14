package hibernate.HibernateAssignment.topic3.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import hibernate.HibernateAssignment.topic1.entity.EmployeeEntity;
import hibernate.HibernateAssignment.topic2.entity.EmployeeManagementEntity;
import hibernate.HibernateAssignment.topic3.entity.MultiOptions;
import hibernate.HibernateAssignment.topic3.entity.Question;
import hibernate.HibernateAssignment.util.HibernateUtil;

public class TopicThreeAssignmentOneManager {

	public static void main(String[] args) {
		
      System.out.println("**************************************************************\n");
      System.out.println("\n");
      
      System.out.println("\n*********Saving Questions with its options *********\n");
      
      Session session = HibernateUtil.getSessionFactory().openSession();
	  
	  // Question 1
	  List<MultiOptions> q1MultiOptions1 = new ArrayList<>();
	  q1MultiOptions1.add(new MultiOptions("a"));
	  q1MultiOptions1.add(new MultiOptions("b"));
	  q1MultiOptions1.add(new MultiOptions("c"));
	  q1MultiOptions1.add(new MultiOptions("d"));
	  
	  Question question1 = new Question("Fullform of ABC", "a",q1MultiOptions1);
	  
	  // Question 2
	  List<MultiOptions> q1MultiOptions2 = new ArrayList<>();
	  q1MultiOptions2.add(new MultiOptions("a"));
	  q1MultiOptions2.add(new MultiOptions("b"));
	  q1MultiOptions2.add(new MultiOptions("c"));
	  q1MultiOptions2.add(new MultiOptions("d"));
	  
	  Question question2 = new Question("Is ABC is a company", "b",q1MultiOptions2);
	  
	  // Question 3 
	  List<MultiOptions> q1MultiOptions3 = new ArrayList<>();
	  q1MultiOptions3.add(new MultiOptions("a"));
	  q1MultiOptions3.add(new MultiOptions("b"));
	  q1MultiOptions3.add(new MultiOptions("c"));
	  q1MultiOptions3.add(new MultiOptions("d"));
	  
	  Question question3 = new Question("Wipro is a company", "c",q1MultiOptions2);
	  
	  System.out.println("Inserting first question");
	  session.beginTransaction();
	  session.save(question1);
	  session.getTransaction().commit();
	  
	  System.out.println("Inserting Second question");
	  session.beginTransaction();
	  session.save(question2);
	  session.getTransaction().commit();
	  
	  System.out.println("Inserting third question");
	  session.beginTransaction();
	  session.save(question3);
	  session.getTransaction().commit();
	}
}
