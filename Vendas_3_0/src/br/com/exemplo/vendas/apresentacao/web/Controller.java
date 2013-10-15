package br.com.exemplo.vendas.apresentacao.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends BusinessController
{
	public void init( )
	{
		try
		{
			super.initController( );
		}
		catch ( BusinessControllerException _exception )
		{
			System.out.println( _exception.getMessage( ) );
		}
	}

	public void process( HttpServletRequest _request,
	        HttpServletResponse _response )
	{
		try
		{
			super.processController( _request, _response );
		}
		catch ( BusinessControllerException _exception )
		{
			System.out.println( _exception.getMessage( ) );
		}

	}

	public void doGet( HttpServletRequest _request,
	        HttpServletResponse _response )
	{
		this.process( _request, _response );
	}

	public void doPost( HttpServletRequest _request,
	        HttpServletResponse _response )
	{
		this.process( _request, _response );
	}

}
