package br.com.controleaereo.bo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.controleaereo.bean.Assento;
import br.com.controleaereo.bean.Usuario;
import br.com.controleaereo.bean.Voo;
import br.com.controleaereo.dao.ReservaDao;
import br.com.controleaereo.dao.VooDao;

@Service
public class VooBO {

	@Inject
	private VooDao vooDao;

	@Inject
	private ReservaDao reservaDao;

	private static VooBO INSTANCE;

	private VooBO() {
		if (INSTANCE == null) {
			INSTANCE = this;
		}
	}

	public static VooBO getInstance() {
		return INSTANCE;
	}

	public void cadastra(Voo voo) throws Exception {
		vooDao.save(voo);
	}

	public List<Voo> recuperaVoos() {
		List<Voo> voos = vooDao.listAll();
		return voos;
	}

	public Voo recuperaVoo(Long id) {
		return vooDao.find(id);
	}

	public void reservar(Usuario u, List<Assento> assentos, String[] selecteds) {
		List<Assento> assentosAux = recuperaAssentosSelecionados(selecteds, assentos);
		for (Assento assento : assentosAux) {
			assento.setIdUsuario(u.getId());
			reservaDao.update(assento);
		}
	}

	public List<Assento> recuperaAssentosDisponiveis(Usuario u, Long idVoo) {
		List<Assento> list = vooDao.findAssentos(u.getId(), idVoo);
		for (Assento assento : list) {
			if(assento.getIdUsuario().intValue() == u.getId()){
				assento.setSelected("true");
			}else{
				assento.setSelected("false");
			}
		}
		return list;
	}

	private List<Assento> recuperaAssentosSelecionados(
			String[] assentosSelecionados, List<Assento> listAssentos) {
		List<Assento> listSelectedAssentos = new ArrayList<Assento>();
		for (Assento assento : listAssentos) {
			for (int i = 0; i < assentosSelecionados.length; i++) {
				if (assentosSelecionados[i].equals(assento.getId().toString())) {
					listSelectedAssentos.add(assento);
					continue;
				}
			}
		}
		return listSelectedAssentos;
	}

}