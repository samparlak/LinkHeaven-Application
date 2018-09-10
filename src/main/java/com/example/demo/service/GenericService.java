package com.example.demo.service;

import java.util.List;

public interface GenericService<T> {

	List<T> getAll();
	T getOne(int theId);
	List<T> searchByHeader(String theHeader);
	List<T> sortHeader();
	List<T> sortDate();
	void createOne(T theObject);
	T updateOne(T theObject);
	void deleteOne(int theId);
	
}
