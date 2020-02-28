/**
 * 
 */
package org.perscholas.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author CTStudent
 *
 */
public abstract class AbstractService {
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyFirstEE");
	protected static EntityManager em = emf.createEntityManager();

	public AbstractService() {
	}

	public static void close() {
		em.close();
		emf.close();
	}
}
