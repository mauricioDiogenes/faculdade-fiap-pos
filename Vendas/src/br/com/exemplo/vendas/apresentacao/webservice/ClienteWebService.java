package br.com.exemplo.vendas.apresentacao.webservice;

import br.com.exemplo.vendas.apresentacao.service.ServiceCliente;
import br.com.exemplo.vendas.negocio.model.vo.ClienteVO;
import br.com.exemplo.vendas.util.exception.LayerException;

public class ClienteWebService {

	public ClienteVO[] selecionarClientesComCompra() throws LayerException{
		ServiceCliente service = new ServiceCliente();
		ClienteVO[] clientes = service.selecionarClientesComCompra();
		return clientes;
	}
}
