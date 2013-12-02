package br.com.exemplo.vendas.apresentacao.actions.reserva;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.exemplo.vendas.apresentacao.service.ServiceReserva;
import br.com.exemplo.vendas.apresentacao.web.Action;
import br.com.exemplo.vendas.negocio.entity.Cliente;
import br.com.exemplo.vendas.negocio.entity.Reserva;
import br.com.exemplo.vendas.negocio.model.vo.ReservaVO;
import br.com.exemplo.vendas.util.exception.LayerException;

public class InserirReservaACT implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws LayerException {
		
		BigInteger codigo = new BigInteger(request.getParameter("codigo"));
		Date data = new Date(request.getParameter("data"));
		String atendente = request.getParameter("atendente");
		String situacao = request.getParameter("situacao");
		BigDecimal valor = new BigDecimal(request.getParameter("valor"));
		String clienteRequest = request.getParameter("cliente");

		Cliente cliente = new Cliente();
		Reserva reserva = new Reserva();

		ReservaVO reservaVO = new ReservaVO(codigo, data, atendente, situacao,valor, cliente);
		ServiceReserva service = new ServiceReserva();
		Boolean sucesso = service.inserir(reservaVO);

		if (sucesso.booleanValue()) {
			request.setAttribute("sucesso", sucesso);
		}
		return "index.html";
	}
}
