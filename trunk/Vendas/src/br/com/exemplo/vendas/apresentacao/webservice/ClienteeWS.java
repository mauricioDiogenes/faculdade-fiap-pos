package br.com.exemplo.vendas.apresentacao.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import br.com.exemplo.vendas.apresentacao.service.ServiceCliente;
import br.com.exemplo.vendas.negocio.model.vo.ClienteVO;
import br.com.exemplo.vendas.util.exception.LayerException;

@Path("/cliente")
public class ClienteeWS {

	@GET
	public ClienteVO[] selecionarClientesComCompra() throws LayerException{
		ServiceCliente service = new ServiceCliente();
		ClienteVO[] clientes = service.selecionarClientesComCompra();
		return clientes;
	}
}
