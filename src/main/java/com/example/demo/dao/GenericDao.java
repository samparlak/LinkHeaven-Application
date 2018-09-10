package com.example.demo.dao;

import java.util.List;


public interface GenericDao<T> {

	List<T> getAll();
	T getOne(int theId);
	List<T> searchByHeader(String theHeader);
	List<T> sortHeader();
	List<T> sortDate();
	void createOne(T theObject);
	T updateOne(T theObject);
	void deleteOne(int theId);
	
}
