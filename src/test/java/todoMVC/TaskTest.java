package todoMVC;

import java.util.List;

import org.junit.Test;

import model.dao.GenericDao;
import model.entities.Task;

/**
 * TaskDao
 *
 * @author dailson
 * @since 15 de jul de 2020
 */
public class TaskTest {

	private Task task = new Task();
	private GenericDao<Task> genericDao = new GenericDao<Task>();

	@Test
	public void insert() {
		task.setName("Task Test");
		genericDao.insert(task);
	}

	@Test
	public void findById() {
		task = genericDao.findById(1L);
		System.out.println(task);
	}

	@Test
	public void update() {
		task = new Task(2L, "NameUpdated2");
		genericDao.update(task);
	}

//	@Test
//	public void remove() {
//		genericDao.removeById(6L);
//	}

	@Test
	public void findAll() {
		List<Task> listTask = genericDao.findAll();
		System.out.println(listTask);
	}

}
