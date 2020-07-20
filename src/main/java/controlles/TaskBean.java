package controlles;

import javax.faces.bean.ManagedBean;

import model.dao.GenericDao;
import model.entities.Task;

/**
 * TaskBean
 *
 * @author dailson
 * @since 20 de jul de 2020
 */
@ManagedBean(name = "taskBean")
public class TaskBean {

	private Task task = new Task();
	private GenericDao<Task> genericDao = new GenericDao<Task>();

	
	
	// CRUD METHODS 
	

	/**
	 * @return boolean
	 */
	public boolean save() {
		genericDao.insert(task);
		return true;
	}

	
	
	// GETTERS AND SETTERS METHODS 

	/**
	 * @return the task
	 */
	public Task getTask() {
		return task;
	}

	/**
	 * @param task the task to set
	 */
	public void setTask(Task task) {
		this.task = task;
	}

	/**
	 * @return the genericDao
	 */
	public GenericDao<Task> getGenericDao() {
		return genericDao;
	}

	/**
	 * @param genericDao the genericDao to set
	 */
	public void setGenericDao(GenericDao<Task> genericDao) {
		this.genericDao = genericDao;
	}

}
