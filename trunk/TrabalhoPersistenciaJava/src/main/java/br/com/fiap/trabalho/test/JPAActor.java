package br.com.fiap.trabalho.test;

import java.util.Date;

import br.com.fiap.trabalho.dao.AbstractDAOFactory;
import br.com.fiap.trabalho.dao.JDBCActorDao;
import br.com.fiap.trabalho.dao.JPADAOFactory;
import br.com.fiap.trabalho.entity.Actor;

public class JPAActor {
	public static void main(String[] args) {
		AbstractDAOFactory abstractDAOFactory = new JPADAOFactory();
		JDBCActorDao actorDAO = (JDBCActorDao) abstractDAOFactory.createActorDAO();
		
		Actor actor = new Actor();
		actor.setFullName("jose");
		actor.setBirthDate(new Date("10/10/2010"));
		actorDAO.createActor(actor);
	}
}
