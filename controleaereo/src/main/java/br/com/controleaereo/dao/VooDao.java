package br.com.controleaereo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.controleaereo.bean.Assento;
import br.com.controleaereo.bean.Voo;

@Repository
@SuppressWarnings("unchecked")
public class VooDao extends SessionFac implements GenericDAO<Voo> {

	private static VooDao INSTANCE;

	private VooDao() {
		if (INSTANCE == null) {
			INSTANCE = this;
		}
	}

	public static VooDao getInstance() {
		return INSTANCE;
	}

	@Override
	public List<Voo> listAll() {
		List<Voo> voos = (List<Voo>) getSession().createQuery("from Voo")
				.list();
		return voos;
	}

	@Override
	public Voo find(Long id) {
		Voo c = (Voo) getSession().get(Voo.class, id);
		return c;
	}

	@Override
	public Voo update(Voo t) {
		getSession().update(t);
		return t;
	}

	@Override
	public Voo save(Voo t) throws Exception {
		getSession().save(t);
		return t;
	}

	@Override
	public void delete(Voo t) {
		getSession().delete(t);
	}

	public List<Assento> findAssentos(int idUsuario, Long idVoo) {
		return (List<Assento>) getSession().createQuery(
				"From Assento where Assento.idUsuario = 0");
	}

}
