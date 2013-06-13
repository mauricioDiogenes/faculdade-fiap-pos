package br.com.controleaereo.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import br.com.controleaereo.bean.Cliente;

@SuppressWarnings("static-access")
public class ClienteDao implements GenericDAO<Cliente> {

	@Inject
	private SessionFactory sessionFactory;
	
	private static ClienteDao INSTANCE;
	
	private static Session session;
	
	private ClienteDao() {
		if (INSTANCE == null) {
			INSTANCE = this;
		}
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.session = sessionFactory.openSession();
	}

	public static ClienteDao getInstance() {
		return INSTANCE;
	}

	@Override
	public List<Cliente> listAll() {

		return null;
	}

	@Override
	public Cliente find(Long id) {
		Cliente c = (Cliente) session.get(Cliente.class, id);
		return c;
	}

	@Override
	public Cliente update(Cliente t) {
		session.update(t);
		return t;
	}

	@Override
	public Cliente save(Cliente t) {
		ShaPasswordEncoder sha = new ShaPasswordEncoder();
		t.setSenha(sha.encodePassword(t.getSenha(), "256"));
		session.save(t);
		return t;
	}

	@Override
	public void delete(Cliente t) {
		session.delete(t);
	}

}
