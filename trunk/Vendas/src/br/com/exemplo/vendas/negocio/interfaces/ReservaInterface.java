package br.com.exemplo.vendas.negocio.interfaces ;

import java.math.BigInteger;

public interface ReservaInterface
{
	public br.com.exemplo.vendas.util.dto.ServiceDTO inserirReserva(
			br.com.exemplo.vendas.util.dto.ServiceDTO requestDTO )
			throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException ;

	public br.com.exemplo.vendas.util.dto.ServiceDTO alterarReserva(
			br.com.exemplo.vendas.util.dto.ServiceDTO requestDTO )
			throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException ;

	public br.com.exemplo.vendas.util.dto.ServiceDTO excluirReserva(
			br.com.exemplo.vendas.util.dto.ServiceDTO requestDTO )
			throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException ;

	public br.com.exemplo.vendas.util.dto.ServiceDTO selecionarTodasReservas(
			br.com.exemplo.vendas.util.dto.ServiceDTO requestDTO )
			throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException ;

	public br.com.exemplo.vendas.util.dto.ServiceDTO getReserva(
			br.com.exemplo.vendas.util.dto.ServiceDTO requestDTO, BigInteger codigo )
			throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException ;
}
