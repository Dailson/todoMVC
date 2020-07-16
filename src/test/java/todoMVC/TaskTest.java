package todoMVC;

import org.junit.Test;

import db.DB;
import model.dao.TaskDao;
import model.dao.impl.TaskDaoJPA;
import model.entities.Task;

/**
 * TaskDao
 *
 * @author dailson
 * @since 15 de jul de 2020
 */
public class TaskTest{

		
	TaskDao task = new TaskDaoJPA(DB.getEntityManager());
	
	@Test
	public void insert() {
		task.insert(new Task(null, "Task1"));
	}

}
