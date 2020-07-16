package todoMVC;

import java.util.List;

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
public class TaskTest {

	TaskDao taskDao = new TaskDaoJPA(DB.getEntityManager());

	@Test
	public void insert() {
		taskDao.insert(new Task(null, "Task1"));
	}

	@Test
	public void findById() {
		Task task = taskDao.findById(1L);
		System.out.println(task);
	}

	@Test
	public void update() {
		Task task = new Task(1L, "NameUpdated");
		taskDao.update(task);
	}

	@Test
	public void findAll() {
		List<Task> listTask = taskDao.findAll();
		System.out.println(listTask);
	}
}
