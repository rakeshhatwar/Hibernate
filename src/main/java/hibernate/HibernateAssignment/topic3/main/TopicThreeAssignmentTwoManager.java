package hibernate.HibernateAssignment.topic3.main;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;

import hibernate.HibernateAssignment.topic3.entity.Capital;
import hibernate.HibernateAssignment.topic3.entity.Continent;
import hibernate.HibernateAssignment.topic3.entity.Country;
import hibernate.HibernateAssignment.util.HibernateUtil;

public class TopicThreeAssignmentTwoManager {

	public static void main(String[] args) {
		
      System.out.println("**************************************************************\n");
      System.out.println("\n");
      
      System.out.println("\n*********Saving Continent, Country with its Capital *********\n");
      
      Session session = HibernateUtil.getSessionFactory().openSession();
	  
	  // Country 1
      Map<Country, Capital> map1 = new HashMap<>();
      map1.put(new Country("India"), new Capital("Delhi"));
      map1.put(new Country("Nepal"), new Capital("Kathmandu"));
      map1.put(new Country("Bangladesh"), new Capital("Dhaka"));
      map1.put(new Country("Sri Lanka"), new Capital("Colombo"));
      map1.put(new Country("Burma"), new Capital("Burma"));
      map1.put(new Country("Myanmar"), new Capital("Colombo"));
      map1.put(new Country("Rashaya"), new Capital("Lebanon"));
      map1.put(new Country("Afghanistan "), new Capital("Kabul"));
      map1.put(new Country("Iran"), new Capital("Tehran"));
      map1.put(new Country("Iraq"), new Capital("Baghdad"));
      
      Continent continent = new Continent("Asia",map1);
      
	  System.out.println("Inserting 1st Continent");
	  session.beginTransaction();
	  session.save(continent);
	  session.getTransaction().commit();
	}
}
