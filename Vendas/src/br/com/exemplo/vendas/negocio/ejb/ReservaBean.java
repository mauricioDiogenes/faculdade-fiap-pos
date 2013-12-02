package br.com.exemplo.vendas.negocio.ejb;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.exemplo.vendas.negocio.dao.DaoFactory;
import br.com.exemplo.vendas.negocio.ejb.interfaces.ReservaLocal;
import br.com.exemplo.vendas.negocio.ejb.interfaces.ReservaRemote;
import br.com.exemplo.vendas.negocio.entity.Reserva;
import br.com.exemplo.vendas.negocio.model.vo.ReservaVO;
import br.com.exemplo.vendas.util.dto.ServiceDTO;
import br.com.exemplo.vendas.util.exception.LayerException;

@Stateless
public class ReservaBean implements ReservaRemote, ReservaLocal {
	@PersistenceContext(unitName = "Vendas")
	EntityManager em;

	public ServiceDTO inserirReserva(ServiceDTO requestDTO) throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		ReservaVO vo = (ReservaVO) requestDTO.get("ReservaVO");
		if (vo != null) {
			Reserva reserva = new Reserva(vo.getCodigo(), vo.getData(), vo.getAtendente(), vo.getSituacao(), vo.getValor(), vo.getCliente());
			if (DaoFactory.getReservaDAO(em).inserir(reserva)) {
				responseDTO.set("resposta", new Boolean(true));
			} else {
				responseDTO.set("resposta", new Boolean(false));
			}
		}
		return responseDTO;
	}

	public ServiceDTO alterarReserva(ServiceDTO requestDTO) throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		ReservaVO vo = (ReservaVO) requestDTO.get("ReservaVO");
		if (vo != null) {
			Reserva reserva = new Reserva(vo.getCodigo(), vo.getData(), vo.getAtendente(), vo.getSituacao(), vo.getValor(), vo.getCliente());
			if (DaoFactory.getReservaDAO(em).alterar(reserva)) {
				responseDTO.set("resposta", new Boolean(true));
			} else {
				responseDTO.set("resposta", new Boolean(false));
			}
		}
		return responseDTO;
	}

	public ServiceDTO excluirReserva(ServiceDTO requestDTO) throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		ReservaVO vo = (ReservaVO) requestDTO.get("ReservaVO");
		if (vo != null) {
			Reserva reserva = new Reserva();
			reserva.setCodigo(vo.getCodigo());
			if (DaoFactory.getReservaDAO(em).excluir(reserva)) {
				responseDTO.set("resposta", new Boolean(true));
			} else {
				responseDTO.set("resposta", new Boolean(false));
			}
		}
		return responseDTO;
	}

	public ServiceDTO selecionarTodasReservas(ServiceDTO requestDTO)
			throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		Reserva reserva = null;
		List<Reserva> lista = DaoFactory.getReservaDAO(em).listar();
		if ((lista != null) && (!lista.isEmpty())) {
			ReservaVO[] reservas = new ReservaVO[lista.size()];
			for (int i = 0; i < lista.size(); i++) {
				reserva = (Reserva) lista.get(i);
				ReservaVO reservaVO = new ReservaVO(reserva.getCodigo(), reserva.getData(), reserva.getAtendente(), reserva.getSituacao(), reserva.getValor(), reserva.getCliente());
				reservas[i] = reservaVO;
			}
			responseDTO.set("listaReserva", reservas);
		}
		return responseDTO;
	}

	public ServiceDTO getReserva(ServiceDTO requestDTO, BigInteger id)
			throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		Reserva reserva = new Reserva();
		reserva.setCodigo(id);
		Reserva lista = DaoFactory.getReservaDAO(em).localizarPorId(reserva);
		if (lista != null) {
			reserva = (Reserva) lista;
			ReservaVO reservaVO = new ReservaVO(reserva.getCodigo(), reserva.getData(), reserva.getAtendente(), reserva.getSituacao(), reserva.getValor(), reserva.getCliente());
			responseDTO.set("getReserva", reservaVO);
		}
		return responseDTO;
	}
}
