package br.com.exemplo.vendas.apresentacao.actions.produto ;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.exemplo.vendas.apresentacao.service.ServiceProduto;
import br.com.exemplo.vendas.apresentacao.web.Action;
import br.com.exemplo.vendas.negocio.model.vo.ProdutoVO;
import br.com.exemplo.vendas.util.exception.LayerException;

public class InserirProdutoACT implements Action
{
	public String execute( HttpServletRequest request, HttpServletResponse response )
			throws LayerException
	{
		String login = request.getParameter( "quantidade" );
		String senha = request.getParameter( "situacao" );
		String grupo = request.getParameter( "reserva" );
		String perfil = request.getParameter( "comprar" );
		String bloqueado = request.getParameter( "bloqueado" );

		ProdutoVO produtoVo = new ProdutoVO();
		

		ServiceProduto service = new ServiceProduto( ) ;
		Boolean sucesso = service.inserir( produtoVo ) ;

		if (sucesso.booleanValue( ))
		{
			request.setAttribute( "sucesso", sucesso ) ;
		}
		return "index.html" ;
	}
}
