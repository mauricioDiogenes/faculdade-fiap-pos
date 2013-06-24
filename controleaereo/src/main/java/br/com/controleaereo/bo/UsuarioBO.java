package br.com.controleaereo.bo;

import javax.inject.Inject;

import br.com.controleaereo.bean.Usuario;
import br.com.controleaereo.dao.UsuarioDao;

public class UsuarioBO {

	@Inject
	private UsuarioDao usuarioDao;
	
	private static UsuarioBO INSTANCE;

	private UsuarioBO() {
		if (INSTANCE == null) {
			INSTANCE = this;
		}
	}

	public static UsuarioBO getInstance() {
		return INSTANCE;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setClienteDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}


	public void cadastra(Usuario usuario){
		usuarioDao.save(usuario);
	}
	
	
}
