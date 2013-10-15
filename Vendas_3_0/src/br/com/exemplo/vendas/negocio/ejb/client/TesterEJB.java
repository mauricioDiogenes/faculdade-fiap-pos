package br.com.exemplo.vendas.negocio.ejb.client;

import java.util.Date;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import br.com.exemplo.vendas.negocio.interfaces.UsuarioInterface;
import br.com.exemplo.vendas.negocio.model.vo.UsuarioVO;
import br.com.exemplo.vendas.util.dto.ServiceDTO;

public class TesterEJB {

	public static void main(String[] args) throws Exception
	{
		Hashtable prop = new Hashtable( );
		prop.put(InitialContext.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		prop.put(InitialContext.PROVIDER_URL, "jnp://localhost:1099");

		Context ctx = new InitialContext( prop ) ;
	   
		UsuarioInterface remote = (UsuarioInterface) ctx.lookup("UsuarioBean/remote");

		ServiceDTO requestDTO 	= new ServiceDTO( ) ;
		ServiceDTO responseDTO 	= new ServiceDTO( ) ;

		/**
		 * Inserir usuario
		 */
		UsuarioVO vo = new UsuarioVO( "marcao1", "senha1111", "grupo1111", "perfil1111", "S", new Date( ), "marcos macedo" ) ;
		requestDTO.set("usuarioVO", vo ) ;
		responseDTO = remote.inserirUsuario( requestDTO ) ;
		Boolean sucesso = ( Boolean ) responseDTO.get("resposta") ;
		if ( sucesso.booleanValue( ) )
		{
			System.out.println("Sucesso na execução do processo!");
		}

//		/**
//		 * Alterar usuario
//		 */
//		UsuarioVO vo = new UsuarioVO( "marcao", "123456", "grupo3333", "perfi4444", "S", new Date( ), "marcos r. macedo" ) ;
//		requestDTO.set("usuarioVO", vo ) ;
//		responseDTO = remote.alterarUsuario( requestDTO ) ;
//		Boolean sucesso = ( Boolean ) responseDTO.get("resposta") ;
//		if ( sucesso.booleanValue( ) )
//		{
//			System.out.println("Sucesso na execução do processo!");
//		}

//		/**
//		 * Excluir usuario
//		 */
//		UsuarioVO vo = new UsuarioVO( "marcao", "123456", "grupo3333", "perfi4444", "S", new Date( ), "marcos r. macedo" ) ;
//		requestDTO.set("usuarioVO", vo ) ;
//		responseDTO = remote.excluirUsuario(  requestDTO ) ;
//		Boolean sucesso = ( Boolean ) responseDTO.get("resposta") ;
//		if ( sucesso.booleanValue( ) )
//		{
//			System.out.println("Sucesso na execução do processo!");
//		}
		
		/**
		 * Consultar usuario
		 */
//		UsuarioVO vo = new UsuarioVO( "marcao", "123456", "grupo3333", "perfi4444", "S", new Date( ), "marcos r. macedo" ) ;
//		requestDTO.set("usuarioVO", vo ) ;
		responseDTO = remote.selecionarTodosUsuario( requestDTO ) ;
		UsuarioVO[ ] lista = ( UsuarioVO[ ] ) responseDTO.get( "listaUsuario" ) ;
		if ( lista != null )
		{
			for ( int i = 0; i < lista.length; i++ )
            {
	            UsuarioVO usuarioVO = ( UsuarioVO ) lista[ i ] ;
	            System.out.println( usuarioVO ) ;
            }
		}
	}

}
