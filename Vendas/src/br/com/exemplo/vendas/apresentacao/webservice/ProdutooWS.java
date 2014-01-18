package br.com.exemplo.vendas.apresentacao.webservice;

import java.math.BigDecimal;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.exemplo.vendas.apresentacao.service.ServiceProduto;
import br.com.exemplo.vendas.negocio.model.vo.ProdutoVO;
import br.com.exemplo.vendas.util.exception.LayerException;

@Path("/produto")
public class ProdutooWS {
	
	
	public ProdutoVO[] listarPorPrecoEstoque() throws LayerException{
		ServiceProduto service = new ServiceProduto();
		ProdutoVO[] produtos = service.listarPorPrecoEstoque(new BigDecimal(1000), 2);
		return produtos;
	}
	
	@GET
	@Produces(value="application/xml")
	public Response getMsg() {
		return Response.status(200).entity("teste").build();
	}
}