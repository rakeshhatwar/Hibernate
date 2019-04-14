package hibernate.HibernateAssignment.topic3.main;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;

import hibernate.HibernateAssignment.topic3.entity.Album;
import hibernate.HibernateAssignment.util.HibernateUtil;

public class TopicThreeAssignmentThreeManager {

	public static void main(String[] args) {
		
      System.out.println("**************************************************************\n");
      System.out.println("\n");
      
      System.out.println("\n*********Saving Continent, Country with its Capital *********\n");
      
      Session session = HibernateUtil.getSessionFactory().openSession();
	  
      //Event and Photo name 
      Map<String,String> map1 = new HashMap<>();
      map1.put("Engagement", "Group photo");
      map1.put("Marriage", "Family photo");
      map1.put("Reception", "Friends photo");
      map1.put("Naming sermon", "Neighbor photo");
      map1.put("Anniversary", "Sitting photo");
      map1.put("Brothers Marriage", "Standing photo");
      map1.put("Sisters Marriage", "Running photo");
      
      Album album = new Album("Family",map1);
      
	  System.out.println("Inserting Album");
	  session.beginTransaction();
	  session.save(album);
	  session.getTransaction().commit();
	}
}
