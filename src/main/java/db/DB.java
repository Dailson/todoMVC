package db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * DB
 *
 * This class is responsible to initiates the parameters connection
 *
 * @author dailson
 * @since 15 de jul de 2020
 */
public class DB {
	
	private static EntityManagerFactory factory = null;
	
	static {
		iniFactory();
	}

	/**
	 * This method is responsible the gives a connection when it is called.
	 * It returns an EntityManager.
	 * 
	 * @return Entity manager instance
	 */
	public static EntityManager getEntityManager(){
		return factory.createEntityManager();
	}
	
	/**
	 * This method is responsible to initiates the EntityManagerFactory and giving
	 * it all metadata from persistence.xml file
	 */
	private static void iniFactory() {
		try {
			if(factory == null) {
				factory = Persistence.createEntityManagerFactory("todoMVC");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
