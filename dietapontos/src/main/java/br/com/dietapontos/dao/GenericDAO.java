package br.com.dietapontos.dao;

import java.util.List;

import org.hibernate.SessionFactory;

public interface GenericDAO<T> {
	
	public List<T> listAll();
	public T find(Long id);
	public T update(T t);
	public T save(T t);
	public void delete(T t);

}
