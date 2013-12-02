
package br.com.exemplo.vendas.apresentacao.service ;

import java.util.Arrays;
import java.util.List;

import br.com.exemplo.vendas.apresentacao.delegate.BusinessDelegate;
import br.com.exemplo.vendas.negocio.model.vo.ReservaVO;
import br.com.exemplo.vendas.util.dto.ServiceDTO;
import br.com.exemplo.vendas.util.exception.LayerException;

public class ServiceReserva
{
	public Boolean inserir( ReservaVO vo ) throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;

		requestDTO.set( "ReservaVO", vo ) ;
		responseDTO = BusinessDelegate.getInstance( ).inserirReserva( requestDTO ) ;
		Boolean sucesso = ( Boolean ) responseDTO.get( "resposta" ) ;

		return sucesso ;
	}

	public List<ReservaVO> listar( ) throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;

		responseDTO = BusinessDelegate.getInstance( ).selectionarTodasReservas( requestDTO ) ;
		ReservaVO[ ] Reservas = ( ReservaVO[ ] ) responseDTO.get( "listaReserva" ) ;
		List<ReservaVO> lista = Arrays.asList( Reservas ) ;
		return lista ;
	}

	public Boolean alterar( ReservaVO vo ) throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;

		requestDTO.set( "ReservaVO", vo ) ;
		responseDTO = BusinessDelegate.getInstance( ).alterarReserva( requestDTO ) ;
		Boolean sucesso = ( Boolean ) responseDTO.get( "resposta" ) ;

		return sucesso ;
	}

	public Boolean excluir( ReservaVO vo ) throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;

		requestDTO.set( "ReservaVO", vo ) ;
		responseDTO = BusinessDelegate.getInstance( ).excluirReserva( requestDTO ) ;
		Boolean sucesso = ( Boolean ) responseDTO.get( "resposta" ) ;

		return sucesso ;
	}
}