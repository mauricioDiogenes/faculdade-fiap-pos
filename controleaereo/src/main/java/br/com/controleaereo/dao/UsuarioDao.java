package br.com.controleaereo.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import br.com.controleaereo.bean.Usuario;

@SuppressWarnings("static-access")
public class UsuarioDao implements GenericDAO<Usuario> {

	@Inject
	private SessionFactory sessionFactory;
	
	private static UsuarioDao INSTANCE;
	
	private static Session session;
	
	private UsuarioDao() {
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

	public static UsuarioDao getInstance() {
		return INSTANCE;
	}

	@Override
	public List<Usuario> listAll() {

		return null;
	}

	@Override
	public Usuario find(Long id) {
		Usuario c = (Usuario) session.get(Usuario.class, id);
		return c;
	}

	@Override
	public Usuario update(Usuario t) {
		session.update(t);
		return t;
	}

	@Override
	public Usuario save(Usuario t) {
		ShaPasswordEncoder sha = new ShaPasswordEncoder();
		t.setSenha(sha.encodePassword(t.getSenha(), "256"));
		session.save(t);
		return t;
	}

	@Override
	public void delete(Usuario t) {
		session.delete(t);
	}

}
