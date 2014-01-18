package br.com.exemplo.vendas.apresentacao.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import br.com.exemplo.vendas.apresentacao.service.ServiceCompra;
import br.com.exemplo.vendas.negocio.model.vo.CompraVO;
import br.com.exemplo.vendas.util.exception.LayerException;

@Path("/compra")
public class CompraaWS {

	@GET
	public CompraVO[] listarValorEntre(int val1, int val2) throws LayerException{
		ServiceCompra service = new ServiceCompra();
		CompraVO[] lista = service.listarValorEntre(val1, val2);
		return lista;
	}
	
	@GET
	public CompraVO[] listarComprasComReserva() throws LayerException{
		ServiceCompra service = new ServiceCompra();
		CompraVO[] lista = service.listarComprasComReserva();
		return lista;
	}
}