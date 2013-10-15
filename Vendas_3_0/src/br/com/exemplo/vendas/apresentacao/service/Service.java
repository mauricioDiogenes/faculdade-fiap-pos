package br.com.exemplo.vendas.apresentacao.service;

import br.com.exemplo.vendas.apresentacao.delegate.BusinessDelegate;
import br.com.exemplo.vendas.negocio.model.vo.CompraVO;
import br.com.exemplo.vendas.negocio.model.vo.UsuarioVO;
import br.com.exemplo.vendas.util.dto.ServiceDTO;
import br.com.exemplo.vendas.util.exception.LayerException;

public class Service
{
	public Boolean inserirUsuario( UsuarioVO vo ) throws LayerException 
	{
		ServiceDTO requestDTO = new ServiceDTO( );
		ServiceDTO responseDTO = new ServiceDTO( );
		
		requestDTO.set( "usuarioVO", vo );
		responseDTO = BusinessDelegate.getInstance( ).inserirUsuario( requestDTO );
		Boolean sucesso = (Boolean)responseDTO.get( "resposta" );
		
		return sucesso ;
	}
	
	
	public Boolean alterarUsuario( UsuarioVO vo ) throws LayerException 
	{
		ServiceDTO requestDTO = new ServiceDTO( );
		ServiceDTO responseDTO = new ServiceDTO( );
		
		requestDTO.set( "usuarioVO", vo );
		responseDTO = BusinessDelegate.getInstance( ).alterarUsuario( requestDTO );
		Boolean sucesso = (Boolean)responseDTO.get( "resposta" );
		
		return sucesso ;
	}
	
	public Boolean excluirUsuario( UsuarioVO vo ) throws LayerException 
	{
		ServiceDTO requestDTO = new ServiceDTO( );
		ServiceDTO responseDTO = new ServiceDTO( );
		
		requestDTO.set( "usuarioVO", vo );
		responseDTO = BusinessDelegate.getInstance( ).excluirUsuario( requestDTO );
		Boolean sucesso = (Boolean)responseDTO.get( "resposta" );
		
		return sucesso ;
	}
	
	public String enviarCompra( CompraVO vo ) throws LayerException
	{
		String ticket = null ;
		ServiceDTO requestDTO = new ServiceDTO( );
		ServiceDTO responseDTO = new ServiceDTO( );
		
		requestDTO.set("compraVO", vo ) ;
		responseDTO = BusinessDelegate.getInstance( ).inserirQueue( requestDTO );
		Boolean sucesso = ( Boolean ) responseDTO.get("resposta") ;
		if ( sucesso.booleanValue( ) )
		{
			ticket = ( String ) responseDTO.get( "ticket" );
		}
		return ticket ;
	}
}