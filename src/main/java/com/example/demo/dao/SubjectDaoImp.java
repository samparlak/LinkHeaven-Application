package com.example.demo.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	@SuppressWarnings("unchecked")
	@Override
	public Set<Subject> search(String word) {
		Set<Subject> mergedSubjects=new HashSet<>();
		List<Subject> subjects1 = entityManager.createQuery("from Subject  where header like :keyword ")
				.setParameter("keyword", "%" + word + "%").getResultList();
		List<Subject> subjects2 = entityManager.createQuery("from Subject  where note like :keyword ")
				.setParameter("keyword", "%" + word + "%").getResultList();
		List<Subject> subjects3 = entityManager.createQuery("from Subject  where link like :keyword ")
				.setParameter("keyword", "%" + word + "%").getResultList();
		mergedSubjects.addAll(subjects1);
		mergedSubjects.addAll(subjects2);
		mergedSubjects.addAll(subjects3);
		return mergedSubjects;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> sortHeader() {
		return entityManager.createQuery("from Subject order by header").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> sortDate() {
		return entityManager.createQuery("from Subject order by date desc").getResultList();
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
