package br.com.exemplo.vendas.apresentacao.actions ;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.exemplo.vendas.apresentacao.service.ServiceCliente;
import br.com.exemplo.vendas.apresentacao.web.Action;
import br.com.exemplo.vendas.negocio.model.vo.ClienteVO;
import br.com.exemplo.vendas.util.exception.LayerException;

public class ListarClientesParaReservaACT implements Action
{
	public String execute( HttpServletRequest request, HttpServletResponse response )
			throws LayerException
	{

		ServiceCliente service = new ServiceCliente( ) ;
		List<ClienteVO> lista = service.listar( ) ;
		request.getSession( ).setAttribute( "listaClientes", lista) ;
		System.out.println("Listando Clientes");
		return "inserirReserva.jsp" ;
	}
}
