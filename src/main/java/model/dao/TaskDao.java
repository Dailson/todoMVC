package model.dao;

import java.util.List;

import model.entities.Task;

/**
 * TaskDao
 *
 * @author dailson
 * @since 15 de jul de 2020
 */
public interface TaskDao {
	
	/**
	 * @param obj
	 */
	void insert(Task obj);
	
	/**
	 * @param obj
	 */
	void update(Task obj);
	
	/**
	 * @param id
	 */
	void deletedById(Integer id);
	
	/**
	 * @param id
	 */
	Task findById(Integer id);
	
	/**
	 * @return List<Task>
	 */
	List<Task> findAll();
	
	
}
