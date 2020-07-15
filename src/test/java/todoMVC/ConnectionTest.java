package todoMVC;

import org.junit.Test;

import db.DB;

/**
 * ConnectionTest
 *
 * @author dailson
 * @since 15 de jul de 2020
 */
public class ConnectionTest {

	@Test
	public void testConnection() {
		DB.getEntityManager();
	}

}
