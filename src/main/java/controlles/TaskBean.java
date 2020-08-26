package controlles;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import model.dao.GenericDao;
import model.entities.Task;

/**
 * TaskBean
 *
 * @author dailson
 * @since 20 de jul de 2020
 */
@Named
@RequestScoped
public class TaskBean {

	private Task task = new Task();
	private GenericDao<Task> genericDao = new GenericDao<Task>();
	private List<Task> listTask = new ArrayList<Task>();

	
	public void loadTasks() {
		listTask = genericDao.findAll();
	}
	
	// CRUD METHODS 
	
	/**
	 * @return boolean
	 */
	public String save() {
		genericDao.insert(task);
		loadTasks();
		return "";
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


	/**
	 * @return the listTask
	 */
	public List<Task> getListTask() {
		return listTask;
	}


	/**
	 * @param listTask the listTask to set
	 */
	public void setListTask(List<Task> listTask) {
		this.listTask = listTask;
	}

}
