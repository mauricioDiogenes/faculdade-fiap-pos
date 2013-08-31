package br.com.fiap.trabalho.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.fiap.trabalho.dao.AbstractDAOFactory;
import br.com.fiap.trabalho.dao.ActorDAO;
import br.com.fiap.trabalho.dao.JPADAOFactory;
import br.com.fiap.trabalho.entity.Actor;

public class ActorTest {

	@Test
	public void insertActor() {
		Actor actor = new Actor();
		actor.setBirthDate(new Date("10/10/2010"));
		actor.setFullName("teste");
		AbstractDAOFactory abstractDAOFactory = new JPADAOFactory();
		ActorDAO actorDAO = abstractDAOFactory.createActorDAO();
		assertEquals(actor, actorDAO.createActor(actor));
	}
	
	@Test
	public void selectActor(){
		AbstractDAOFactory abstractDAOFactory = new JPADAOFactory();
		ActorDAO actorDAO = abstractDAOFactory.createActorDAO();
		List<Actor> actorList = actorDAO.selectActorByName("teste");
		assertNotNull(actorList);
	}

}
