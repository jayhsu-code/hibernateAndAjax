package secondThematic;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class sessionConn {
	private static final SessionFactory sessionFactory=createfactory() ;
	public static SessionFactory createfactory() {

		StandardServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure().build();

		SessionFactory factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		
		return factory;
		
	}
	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	public static void closeFactory() {
		if(sessionFactory!=null) sessionFactory.close();
	}

}
