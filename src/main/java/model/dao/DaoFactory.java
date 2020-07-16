package model.dao;

import db.DB;
import model.dao.impl.TaskDaoJPA;

/**
 * DaoFactory
 *
 * @author dailson
 * @since 16 de jul de 2020
 */
public class DaoFactory {

	public static TaskDao createPersonDao() {
		return new TaskDaoJPA(DB.getEntityManager());
	}
}
