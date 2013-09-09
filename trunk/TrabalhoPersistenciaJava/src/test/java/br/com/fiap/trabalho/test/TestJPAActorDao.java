package br.com.fiap.trabalho.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fiap.trabalho.dao.AbstractDAOFactory;
import br.com.fiap.trabalho.dao.ActorDAO;
import br.com.fiap.trabalho.dao.jpa.JPADAOFactory;
import br.com.fiap.trabalho.entity.Actor;



public class TestJPAActorDao {
	private static ActorDAO actorDAO;
	@Before
	public void init(){
		AbstractDAOFactory abstractDAOFactory = new JPADAOFactory();
		actorDAO = abstractDAOFactory.createActorDAO();
		Actor actor1 = new Actor();
		actor1.setBirthDate(new Date("10/10/2010"));
		actor1.setFullName("actor1");
		actorDAO.createActor(actor1);

		Actor actor2 = new Actor();
		actor2.setBirthDate(new Date("10/10/2011"));
		actor2.setFullName("actor2");
		actorDAO.createActor(actor2);
	}
	
	@Test
	public void validarcreateDao(){
		Assert.assertNotNull(this.actorDAO);
	}

	
	@Test
	public void selectActorByName() {
		List<Actor> actorList = actorDAO.selectActorByName("actor2");
		assertNotNull(actorList);
	}

	@Test
	public void insertActor() {
		Actor actor = new Actor();
		actor.setBirthDate(new Date("10/10/2000"));
		actor.setFullName("actor insert");
		actorDAO.createActor(actor);
	}

	@Test
	public void selectActorByAge() {
		List<Actor> actorList = actorDAO.selectActorByAge(2);
		assertNotNull(actorList);
	}

	@Test
	public void deleteActor() {
		List<Actor> actorList = actorDAO.selectActorByName("actor1");
		int idActor = actorList.get(0).getId();
		actorDAO.deleteActor(actorList.get(0));
		List<Actor> actorList2 = actorDAO.selectActorByName("actor1");
		if(!actorList2.isEmpty()){
			assertTrue(idActor != actorList2.get(0).getId());
		}else{
			assertTrue(true);
		}
	}
}
