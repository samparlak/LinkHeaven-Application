package com.example.demo.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.GenericDao;
import com.example.demo.model.SubjectTable;

@Service
public class SubjectTableServiceImp implements GenericService<SubjectTable> {

	@Autowired
	private GenericDao<SubjectTable> subjectTableDao;

	@Transactional
	@Override
	public List<SubjectTable> getAll() {
		return subjectTableDao.getAll();
	}

	@Transactional
	@Override
	public SubjectTable getOne(int theId) {
		return subjectTableDao.getOne(theId);
	}

	@Transactional
	@Override
	public Set<SubjectTable> search(String word) {
		return subjectTableDao.search(word);
	}

	@Transactional
	@Override
	public List<SubjectTable> sortHeader() {
		return subjectTableDao.sortHeader();
	}

	@Transactional
	@Override
	public List<SubjectTable> sortDate() {
		return subjectTableDao.sortDate();
	}

	@Transactional
	@Override
	public void createOne(SubjectTable theObject) {
		subjectTableDao.createOne(theObject);
	}

	@Transactional
	@Override
	public SubjectTable updateOne(SubjectTable theObject) {
		return subjectTableDao.updateOne(theObject);
	}

	@Transactional
	@Override
	public void deleteOne(int theId) {
		subjectTableDao.deleteOne(theId);
	}

}
