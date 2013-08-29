package br.com.fiap.trabalho.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fiap.trabalho.entity.Actor;



public class TestJPAActorDao {
	
	private EntityManagerFactory factory;
	private EntityManager manager;
	
	@Before
	public void init(){
		factory = Persistence .createEntityManagerFactory ("persistenceUnit");
		manager = factory.createEntityManager ();
		
	}
	
	@After
	public void close(){
		factory.close ();
	}
	
	@Test
	public void validarcreateEntityManagerFactory(){
		Assert.assertNotNull(this.factory);
		Assert.assertNotNull(this.manager);
	}
	
	@Test
	public void insert(){
		Actor actor = new Actor();
		actor.setBirthDate(new Date());
		actor.setFullName("Teste");
		manager.persist(actor);
	}

}
