package br.com.exemplo.vendas.apresentacao.actions ;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.exemplo.vendas.apresentacao.service.ServiceProduto;
import br.com.exemplo.vendas.apresentacao.web.Action;
import br.com.exemplo.vendas.negocio.model.vo.ProdutoVO;
import br.com.exemplo.vendas.util.exception.LayerException;

public class ListarProdutosACT implements Action
{
	public String execute( HttpServletRequest request, HttpServletResponse response )
			throws LayerException
	{

		ServiceProduto service = new ServiceProduto( ) ;
		List<ProdutoVO> lista = service.listar( ) ;

		request.getSession( ).setAttribute( "listaProdutos", lista ) ;

		return "cadastroProduto.jsp" ;
	}
}
