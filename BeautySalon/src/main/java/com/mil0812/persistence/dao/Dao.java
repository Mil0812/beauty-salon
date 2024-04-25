package com.mil0812.learnspring.persistence.dao;

import java.util.List;

public interface Dao<T, E> {
	boolean create(E e);
	List<E> getAll();
	E getById(T id);
	E update(E e);
	boolean delete(T id);
}
