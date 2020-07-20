package model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import db.DB;
import db.DbException;
import model.entities.Task;

/**
 * GenericDao
 *
 * @author dailson
 * @since 20 de jul de 2020
 */
public class GenericDao<T> {

	private EntityManager entity = DB.getEntityManager();

	/**
	 * @param obj
	 */
	public void insert(T obj) {
		try {
			entity.getTransaction().begin();
			entity.persist(obj);
			entity.getTransaction().commit();
		} catch (Exception e) {
			entity.getTransaction().rollback();
			throw new DbException("An error occurred while trying to INSERT a Task record into the database! Caused by "
					+ e.getMessage());
		}
	}

	/**
	 * @param id
	 * @return a Task
	 */
	public Task findById(Long id) {
		Task task = null;
		try {
			entity.getTransaction().begin();
			task = entity.find(Task.class, id);
			entity.getTransaction().commit();
		} catch (Exception e) {
			entity.getTransaction().rollback();
			throw new DbException(
					"An error occurred while trying to FIND BY ID a Task on the database! Caused by " + e.getMessage());

		}
		return task;

	}

	/**
	 * @param obj
	 */
	public void update(T obj) {
		try {
			entity.getTransaction().begin();
			entity.merge(obj);
			entity.getTransaction().commit();
		} catch (Exception e) {
			entity.getTransaction().rollback();
			throw new DbException("An error occurred while trying to UPDATE a Task record from the database! Caused by "
					+ e.getMessage());
		}
	}

	/**
	 * @param id
	 */
	public void removeById(Long id) {
		Task task = entity.find(Task.class, id);
		if (task.getId() != null) {
			try {
				entity.getTransaction().begin();
				entity.remove(task);
				entity.getTransaction().commit();

			} catch (Exception e) {
				entity.getTransaction().rollback();
				throw new DbException(
						"An error occurred while trying to REMOVE a Task record from the database! Caused by "
								+ e.getMessage());
			}
		} else {
			throw new NullPointerException("There is no record on database! It is null");
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		List<T> listTask = new ArrayList<>();
		try {
			entity.getTransaction().begin();
			listTask = entity.createQuery("FROM " + Task.class.getName()).getResultList();
			entity.getTransaction().commit();

		} catch (Exception e) {
			entity.getTransaction().rollback();
			throw new DbException(
					"An error occurred while trying to FIND ALL Tasks from the database! Caused by " + e.getMessage());

		}

		return listTask;
	}
}
