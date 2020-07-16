package model.dao.impl;

import java.util.ArrayList;
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

		try {
			entity.getTransaction().begin();
			entity.merge(obj);
			entity.getTransaction().commit();
		} catch (Exception e) {
			entity.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void deletedById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Task findById(Long id) {
		Task task = null;
		try {
			entity.getTransaction().begin();
			task = entity.find(Task.class, id);
			entity.getTransaction().commit();
		} catch (Exception e) {
			entity.getTransaction().rollback();
			e.printStackTrace();
		}
		return task;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Task> findAll() {
		List<Task> listTask = new ArrayList<>();
		try {
			entity.getTransaction().begin();
			listTask = entity.createQuery("FROM " + Task.class.getName()).getResultList();
			entity.getTransaction().commit();

		} catch (Exception e) {
			entity.getTransaction().rollback();
			e.printStackTrace();
		}

		return listTask;
	}

}
