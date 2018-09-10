package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.SubjectTable;

@Repository
public class SubjectTableDaoImp implements GenericDao<SubjectTable> {

	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<SubjectTable> getAll() {
		return entityManager.createQuery("from SubjectTable").getResultList();
	}

	@Override
	public SubjectTable getOne(int theId) {
		return entityManager.find(SubjectTable.class, theId);
	}

	@Override
	public List<SubjectTable> searchByHeader(String theHeader) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubjectTable> sortHeader() {
		return entityManager.createQuery("from SubjectTable order by header").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubjectTable> sortDate() {
		return entityManager.createQuery("from SubjectTable order by date").getResultList();
	}
	
	@Override
	public void createOne(SubjectTable theObject) {
		entityManager.persist(theObject);
	}

	@Override
	public SubjectTable updateOne(SubjectTable theObject) {
		return entityManager.merge(theObject);
	}

	@Override
	public void deleteOne(int theId) {
		entityManager.remove(entityManager.getReference(SubjectTable.class, theId));
	}

}
