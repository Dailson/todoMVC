package model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import model.dao.TaskDao;
import model.entities.Task;

/**
 * TaskDaoJPA
 *
 * @author dailson
 * @since 16 de jul de 2020
 */
public class TaskDaoJPA implements TaskDao {

	private EntityManager entity;
	
	public TaskDaoJPA(EntityManager entity) {
		this.entity = entity;
	}

	@Override
	public void insert(Task obj) {
		try {
			entity.getTransaction().begin();
			entity.persist(obj);
			entity.getTransaction().commit();

		} catch (Exception e) {
			entity.getTransaction().rollback();
			e.printStackTrace();
		}

	}

	@Override
	public void update(Task obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletedById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Task findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
