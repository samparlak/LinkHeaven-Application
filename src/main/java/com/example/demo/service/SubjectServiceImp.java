package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.GenericDao;
import com.example.demo.model.Subject;

@Service
public class SubjectServiceImp implements GenericService<Subject> {
	
	@Autowired
	private GenericDao<Subject> subjectDao;

	@Transactional
	@Override
	public List<Subject> getAll() {
		return subjectDao.getAll();
	}

	@Transactional
	@Override
	public Subject getOne(int theId) {
		return subjectDao.getOne(theId);
	}

	@Transactional
	@Override
	public List<Subject> searchByHeader(String theHeader) {
		return subjectDao.searchByHeader(theHeader);
	}

	@Transactional
	@Override
	public List<Subject> sortHeader() {
		return subjectDao.sortHeader();
	}

	@Transactional
	@Override
	public List<Subject> sortDate() {
		return subjectDao.sortDate();
	}

	@Transactional
	@Override
	public void createOne(Subject theObject) {
		subjectDao.createOne(theObject);
	}

	@Transactional
	@Override
	public Subject updateOne(Subject theObject) {
		return subjectDao.updateOne(theObject);
	}

	@Transactional
	@Override
	public void deleteOne(int theId) {
		subjectDao.deleteOne(theId);
	}

}
