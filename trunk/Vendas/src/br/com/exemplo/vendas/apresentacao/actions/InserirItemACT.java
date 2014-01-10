package br.com.exemplo.vendas.apresentacao.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.exemplo.vendas.apresentacao.service.ServiceCompra;
import br.com.exemplo.vendas.apresentacao.service.ServiceItem;
import br.com.exemplo.vendas.apresentacao.web.Action;
import br.com.exemplo.vendas.negocio.entity.Compra;
import br.com.exemplo.vendas.negocio.model.vo.ItemVO;
import br.com.exemplo.vendas.util.exception.LayerException;

@SuppressWarnings("unused")
public class InserirItemACT implements Action
{
	public String execute( HttpServletRequest request, HttpServletResponse response )
			throws LayerException
	{
		String numeroCompra = request.getParameter( "compra" );
		String produto = request.getParameter( "produto" );
		String quantidade = request.getParameter( "quantidade" );
		String reserva = request.getParameter( "reserva" );
		String situacao = request.getParameter( "situacao" );
		String valor = request.getParameter( "valor" );

		ServiceCompra serviceCompra = new ServiceCompra( );
		Compra compra = new Compra();
		compra.setNumero(new Integer(numeroCompra));
		
		
		ServiceItem service = new ServiceItem();
		
		ItemVO itemVO = new ItemVO();
		itemVO.setCompra(compra);
		
		Boolean sucesso = service.inserir( itemVO ) ;

		if (sucesso.booleanValue( ))
		{
			request.setAttribute( "sucesso", sucesso ) ;
		}
		return "index.html" ;
	}
}
