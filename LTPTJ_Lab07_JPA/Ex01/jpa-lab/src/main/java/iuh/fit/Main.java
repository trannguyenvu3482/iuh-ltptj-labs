/**
 * 
 */
package iuh.fit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * @author Trần Nguyên Vũ
 * @version 1.0
 * @created 12 Mar 2024
 */
public class Main {
	public static void main(String[] args) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-lab");
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
