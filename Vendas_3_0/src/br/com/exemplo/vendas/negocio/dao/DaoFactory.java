package br.com.exemplo.vendas.negocio.dao ;

import javax.persistence.EntityManager;

import br.com.exemplo.vendas.util.exception.SysException;

public final class DaoFactory
{
	private static DaoFactory myInstance = null ;

	private static UsuarioDAO usuarioDAO_instance ;
	
	private static ProdutoDAO produtoDAO_instance ;
	
	private static ItemDAO itemDAO_instance ;

	private DaoFactory( ) throws SysException
	{
	}

	private synchronized static void initialize( ) throws SysException
	{
		if (myInstance == null)
		{
			myInstance = new DaoFactory( ) ;
		}
	}

	public static UsuarioDAO getUsuarioDAO( EntityManager em ) throws SysException
	{
		initialize( ) ;
		if (usuarioDAO_instance == null)
		{
			usuarioDAO_instance = new UsuarioDAO( em ) ;
		}
		return usuarioDAO_instance ;
	}
	
	public static ProdutoDAO getProdutoDAO( EntityManager em ) throws SysException
	{
		initialize( ) ;
		if (produtoDAO_instance == null)
		{
			produtoDAO_instance = new ProdutoDAO( em ) ;
		}
		return produtoDAO_instance ;
	}
	
	public static ItemDAO getItemDAO( EntityManager em ) throws SysException
	{
		initialize( ) ;
		if (itemDAO_instance == null)
		{
			itemDAO_instance = new ItemDAO( em ) ;
		}
		return itemDAO_instance ;
	}

}
