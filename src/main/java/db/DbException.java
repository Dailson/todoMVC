package db;

/**
 * DbException
 *
 * @author dailson
 * @since 16 de jul de 2020
 */
public class DbException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * @param msg
	 */
	public DbException(String msg) {
		super(msg);
	}
}
