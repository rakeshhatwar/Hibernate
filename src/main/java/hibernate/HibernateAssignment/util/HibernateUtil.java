package hibernate.HibernateAssignment.util;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	 
    private static SessionFactory buildSessionFactory() {
        try {
        	
        	return new AnnotationConfiguration().configure(new File(HibernateUtil.class.getClassLoader().getResource("hibernate.cgf.xml").getPath())).buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    public static void shutdown() {
    	// Close caches and connection pools
    	getSessionFactory().close();
    }
}
