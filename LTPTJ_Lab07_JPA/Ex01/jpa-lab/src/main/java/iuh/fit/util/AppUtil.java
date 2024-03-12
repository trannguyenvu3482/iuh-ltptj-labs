/**
 * 
 */
package iuh.fit.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author Trần Nguyên Vũ
 * @version 1.0
 * @created 12 Mar 2024 - 1:52:14 pm
 */
public class AppUtil {
	private SessionFactory mySessionFactory;

	public void initFactory() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		mySessionFactory = new org.hibernate.cfg.Configuration().buildSessionFactory(registry);
	}

	/**
	 * @return the mySessionFactory
	 */
	public SessionFactory getMySessionFactory() {
		return mySessionFactory;
	}
}
