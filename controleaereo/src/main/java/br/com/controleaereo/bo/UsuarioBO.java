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

	public void cadastra(Usuario usuario){
		usuarioDao.save(usuario);
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	//www.free-codecs.com/download/3gp_player.htm

	public Usuario find(Usuario usuario){
		return usuarioDao.validaUsuario(usuario);
	}
}
