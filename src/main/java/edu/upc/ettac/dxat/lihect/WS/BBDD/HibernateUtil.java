package edu.upc.ettac.dxat.lihect.WS.BBDD;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateUtil {

	private static final SessionFactory sessionFactory; //solo existe una instancia en la aplicaci�n

	static
	{
	    try
	    {
	    sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	    } catch (HibernateException he)
	    {
	        System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
	        throw new ExceptionInInitializerError(he);
	    }
	}
	
	public static SessionFactory getSessionFactory()
	{ 
	    return sessionFactory;
	} 

}
