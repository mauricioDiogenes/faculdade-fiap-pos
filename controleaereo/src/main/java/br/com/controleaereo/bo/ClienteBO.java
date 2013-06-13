package br.com.controleaereo.bo;

import javax.inject.Inject;

import br.com.controleaereo.bean.Cliente;
import br.com.controleaereo.dao.ClienteDao;

public class ClienteBO {

	@Inject
	private ClienteDao clienteDao;
	
	private static ClienteBO INSTANCE;

	private ClienteBO() {
		if (INSTANCE == null) {
			INSTANCE = this;
		}
	}

	public static ClienteBO getInstance() {
		return INSTANCE;
	}

	public ClienteDao getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDao clienteDAO) {
		this.clienteDao = clienteDAO;
	}


	public void cadastra(Cliente cliente){
		clienteDao.save(cliente);
	}
	
	
}
