package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Subject;

@Repository
public class SubjectDaoImp implements GenericDao<Subject> {

	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> getAll() {
		return entityManager.createQuery("from Subject").getResultList();
	}

	@Override
	public Subject getOne(int theId) {
		return entityManager.find(Subject.class, theId);
	}

	@Override
	public List<Subject> searchByHeader(String theHeader) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> sortHeader() {
		return entityManager.createQuery("from Subject order by header").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> sortDate() {
		return entityManager.createQuery("from Subject order by date").getResultList();
	}

	@Override
	public void createOne(Subject theObject) {
		entityManager.persist(theObject);
	}

	@Override
	public Subject updateOne(Subject theObject) {
		return entityManager.merge(theObject);
	}

	@Override
	public void deleteOne(int theId) {
		entityManager.remove(entityManager.getReference(Subject.class, theId));
	}

}
