package br.com.exemplo.vendas.apresentacao.actions.compra ;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.exemplo.vendas.apresentacao.service.ServiceCompra;
import br.com.exemplo.vendas.apresentacao.web.Action;
import br.com.exemplo.vendas.negocio.entity.Cliente;
import br.com.exemplo.vendas.negocio.entity.Reserva;
import br.com.exemplo.vendas.negocio.model.vo.CompraVO;
import br.com.exemplo.vendas.util.exception.LayerException;

public class InserirCompraACT implements Action
{
	
	
	public String execute( HttpServletRequest request, HttpServletResponse response )
			throws LayerException
	{
		
		BigInteger numero = new BigInteger(request.getParameter("numero"));
		Date data = new Date(request.getParameter("data"));
		String responsavel = request.getParameter("responsavel");
		String situacao = request.getParameter("situacao");
		BigDecimal valor = new BigDecimal(request.getParameter("valor"));
		String reservaRequest = request.getParameter("reserva");
		String clienteRequest = request.getParameter("cliente");

		Cliente cliente = new Cliente();
		Reserva reserva = new Reserva();
		
		CompraVO compraVO = new CompraVO(numero, data, responsavel, situacao, valor, reserva, cliente);
		
		ServiceCompra service = new ServiceCompra( ) ;
		Boolean sucesso = service.inserir( compraVO ) ;

		if (sucesso.booleanValue( ))
		{
			request.setAttribute( "sucesso", sucesso ) ;
		}
		return "index.html" ;
	}
}
