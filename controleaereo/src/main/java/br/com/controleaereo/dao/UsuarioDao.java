package br.com.controleaereo.dao;

import java.util.List;

import javax.inject.Inject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import br.com.controleaereo.bean.Usuario;


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

	@SuppressWarnings("static-access")
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

	public Usuario validaUsuario(Usuario usuario) {
		ShaPasswordEncoder sha = new ShaPasswordEncoder();
		usuario.setSenha(sha.encodePassword(usuario.getSenha(), "256"));
		Query query = session
				.createQuery("from Usuario u where u.email = :email and u.senha = :senha");
		query.setParameter("email", usuario.getEmail());
		query.setParameter("senha", usuario.getSenha());
		List<Usuario> lista = query.list();
		Usuario u = null;
		if (lista != null && lista.size() > 0) {
			u = lista.get(0);
		}
		return u;
	}

}
