package br.com.fiap.estoque.bean.test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fiap.estoque.bean.ServiceExemploLocal;

/***
 * Classe de Teste para testes unitarios do EJB
 * @author carlosrgomes@gmail.com
 *
 */
public class TestServiceExemploBean {
	
	private Context context;
	
	@Before
	public void setUp(){
		context = EJBContainer.createEJBContainer().getContext();
	}
	
	@Test
	public void testService() throws NamingException{
		ServiceExemploLocal serviceExemploLocal = (ServiceExemploLocal) context.lookup("java:global/fiap-estoque-bean/ServiceExemploBean");
		Assert.assertEquals("Teste", serviceExemploLocal.metodoExemplo("Teste"));
	}

}
