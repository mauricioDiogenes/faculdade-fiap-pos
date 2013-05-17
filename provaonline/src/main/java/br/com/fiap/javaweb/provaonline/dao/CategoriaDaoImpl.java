package br.com.fiap.javaweb.provaonline.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.fiap.javaweb.provaonline.bean.Categoria;

public class CategoriaDaoImpl implements GenericDAO<Categoria> {
	private Session session;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.session = sessionFactory.openSession();
	}

	@Override
	public List<Categoria> listAll() {
		@SuppressWarnings("unchecked")
		List<Categoria> list = session.createQuery("from Categoria").list();
		return list;
	}

	@Override
	public Categoria find(Long id) {
		return (Categoria) session.get(Categoria.class, id);
	}

	@Override
	public Categoria update(Categoria t) {
		session.merge(t);
		session.flush();
		return t;
	}

	@Override
	public Categoria save(Categoria t) {
		session.saveOrUpdate(t);
		return t;
	}

	@Override
	public void delete(Categoria t) {
		session.delete(t);
	}

}
