package br.com.exemplo.vendas.apresentacao.delegate ;

import java.rmi.RemoteException;

import br.com.exemplo.vendas.negocio.interfaces.ItemInterface;
import br.com.exemplo.vendas.negocio.interfaces.ProdutoInterface;
import br.com.exemplo.vendas.negocio.interfaces.RecebeRequisicaoInterface;
import br.com.exemplo.vendas.negocio.interfaces.UsuarioInterface;
import br.com.exemplo.vendas.util.dto.ServiceDTO;
import br.com.exemplo.vendas.util.exception.LayerException;
import br.com.exemplo.vendas.util.exception.SysExceptionFactory;
import br.com.exemplo.vendas.util.locator.ServiceLocator;
import br.com.exemplo.vendas.util.locator.ServiceLocatorException;
import br.com.exemplo.vendas.util.locator.ServiceLocatorFactory;

public class BusinessDelegate
{
	private static BusinessDelegate instance = null ;

	private ServiceLocator serviceLocator ;

	private BusinessDelegate( ) throws Exception
	{
		setServiceLocator( ) ;
	}

	public synchronized static BusinessDelegate getInstance( ) throws LayerException
	{
		if (instance == null)
		{
			try
			{
				instance = new BusinessDelegate( ) ;
			}
			catch (Exception exception)
			{
				throw SysExceptionFactory.getException( exception ) ;
			}
		}
		return instance ;
	}

	public ServiceDTO inserirQueue( ServiceDTO requestDTO ) throws LayerException
	{
		ServiceDTO responseDTO = new ServiceDTO( ) ;
		try
		{
			responseDTO = ( ( RecebeRequisicaoInterface ) serviceLocator
					.getService( "RecebeRequisicaoBean/remote" ) ).inserirFila( requestDTO ) ;
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException( remoteException ) ;
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException( serviceLocatorException ) ;
		}
		return responseDTO ;
	}
	
	private void setServiceLocator( ) throws Exception
	{
		this.serviceLocator = ServiceLocatorFactory.getServiceLocator( "serviceLocator" ) ;

	}
	
	//*******USUARIO*********
	
	public ServiceDTO inserirUsuario( ServiceDTO requestDTO ) throws LayerException
	{
		ServiceDTO responseDTO = new ServiceDTO( ) ;
		try
		{
			responseDTO = ( ( UsuarioInterface ) serviceLocator.getService( "UsuarioBean/remote" ) )
					.inserirUsuario( requestDTO ) ;
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException( remoteException ) ;
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException( serviceLocatorException ) ;
		}
		return responseDTO ;
	}

	public ServiceDTO excluirUsuario( ServiceDTO requestDTO ) throws LayerException
	{
		ServiceDTO responseDTO = new ServiceDTO( ) ;
		try
		{
			responseDTO = ( ( UsuarioInterface ) serviceLocator.getService( "UsuarioBean/remote" ) )
					.excluirUsuario( requestDTO ) ;
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException( remoteException ) ;
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException( serviceLocatorException ) ;
		}
		return responseDTO ;
	}

	public ServiceDTO alterarUsuario( ServiceDTO requestDTO ) throws LayerException
	{
		ServiceDTO responseDTO = new ServiceDTO( ) ;
		try
		{
			responseDTO = ( ( UsuarioInterface ) serviceLocator.getService( "UsuarioBean/remote" ) )
					.alterarUsuario( requestDTO ) ;
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException( remoteException ) ;
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException( serviceLocatorException ) ;
		}
		return responseDTO ;
	}

	public ServiceDTO selectionarTodosUsuarios( ServiceDTO requestDTO ) throws LayerException
	{
		ServiceDTO responseDTO = new ServiceDTO( ) ;
		try
		{
			responseDTO = ( ( UsuarioInterface ) serviceLocator.getService( "UsuarioBean/remote" ) )
					.selecionarTodosUsuario( requestDTO ) ;
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException( remoteException ) ;
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException( serviceLocatorException ) ;
		}
		return responseDTO ;
	}

	
	
	
	//*******PRODUTO*********
	public ServiceDTO inserirProduto( ServiceDTO requestDTO ) throws LayerException
	{
		ServiceDTO responseDTO = new ServiceDTO( ) ;
		try
		{
			responseDTO = ( ( ProdutoInterface ) serviceLocator.getService( "ProdutoBean/remote" ) )
					.inserirProduto( requestDTO ) ;
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException( remoteException ) ;
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException( serviceLocatorException ) ;
		}
		return responseDTO ;
	}

	public ServiceDTO excluirProduto( ServiceDTO requestDTO ) throws LayerException
	{
		ServiceDTO responseDTO = new ServiceDTO( ) ;
		try
		{
			responseDTO = ( ( ProdutoInterface ) serviceLocator.getService( "ProdutoBean/remote" ) )
					.excluirProduto( requestDTO ) ;
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException( remoteException ) ;
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException( serviceLocatorException ) ;
		}
		return responseDTO ;
	}

	public ServiceDTO alterarProduto( ServiceDTO requestDTO ) throws LayerException
	{
		ServiceDTO responseDTO = new ServiceDTO( ) ;
		try
		{
			responseDTO = ( ( ProdutoInterface ) serviceLocator.getService( "ProdutoBean/remote" ) )
					.alterarProduto( requestDTO ) ;
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException( remoteException ) ;
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException( serviceLocatorException ) ;
		}
		return responseDTO ;
	}

	public ServiceDTO selectionarTodosProdutos( ServiceDTO requestDTO ) throws LayerException
	{
		ServiceDTO responseDTO = new ServiceDTO( ) ;
		try
		{
			responseDTO = ( ( ProdutoInterface ) serviceLocator.getService( "ProdutoBean/remote" ) )
					.selecionarTodosProduto( requestDTO ) ;
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException( remoteException ) ;
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException( serviceLocatorException ) ;
		}
		return responseDTO ;
	}
	
	
	//*******ITEM*********
	
	public ServiceDTO inserirItem( ServiceDTO requestDTO ) throws LayerException
	{
		ServiceDTO responseDTO = new ServiceDTO( ) ;
		try
		{
			responseDTO = ( ( ItemInterface ) serviceLocator.getService( "ItemBean/remote" ) )
					.inserirItem( requestDTO ) ;
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException( remoteException ) ;
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException( serviceLocatorException ) ;
		}
		return responseDTO ;
	}

	public ServiceDTO excluirItem( ServiceDTO requestDTO ) throws LayerException
	{
		ServiceDTO responseDTO = new ServiceDTO( ) ;
		try
		{
			responseDTO = ( ( ItemInterface ) serviceLocator.getService( "ItemBean/remote" ) )
					.excluirItem( requestDTO ) ;
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException( remoteException ) ;
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException( serviceLocatorException ) ;
		}
		return responseDTO ;
	}

	public ServiceDTO alterarItem( ServiceDTO requestDTO ) throws LayerException
	{
		ServiceDTO responseDTO = new ServiceDTO( ) ;
		try
		{
			responseDTO = ( ( ItemInterface ) serviceLocator.getService( "ItemBean/remote" ) )
					.alterarItem( requestDTO ) ;
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException( remoteException ) ;
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException( serviceLocatorException ) ;
		}
		return responseDTO ;
	}

	public ServiceDTO selectionarTodosItems( ServiceDTO requestDTO ) throws LayerException
	{
		ServiceDTO responseDTO = new ServiceDTO( ) ;
		try
		{
			responseDTO = ( ( ItemInterface ) serviceLocator.getService( "ItemBean/remote" ) )
					.selecionarTodosItem( requestDTO ) ;
		}
		catch (RemoteException remoteException)
		{
			throw SysExceptionFactory.getException( remoteException ) ;
		}
		catch (ServiceLocatorException serviceLocatorException)
		{
			throw SysExceptionFactory.getException( serviceLocatorException ) ;
		}
		return responseDTO ;
	}

}