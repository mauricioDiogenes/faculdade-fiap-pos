package br.com.fiap.trabalho.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.fiap.trabalho.entity.Actor;
import br.com.fiap.trabalho.entity.Movie;

/***
 * Classe Dao de JPA
 * 
 * @author carlosrgomes@gmail.com
 * 
 */
public class JPAActorDAO extends JPAConnection implements ActorDAO{

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.fiap.trabalho.dao.ActorDAO#createActor(br.com.fiap.trabalho.entity
	 * .Actor)
	 */
	public Actor createActor(Actor actor) {
		getEntityManager().persist(actor);
		return actor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.fiap.trabalho.dao.ActorDAO#deleteActor(br.com.fiap.trabalho.entity
	 * .Actor)
	 */
	public boolean deleteActor(Actor actor) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.fiap.trabalho.dao.ActorDAO#selectActorByName(java.lang.String)
	 */
	public List<Actor> selectActorByName(String name) {
		Query query = getEntityManager().createQuery(
				"SELECT A FROM Actor A WHERE fullName = :name", Actor.class);
		query.setParameter("name", name);
		return (List<Actor>) query.getSingleResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.fiap.trabalho.dao.ActorDAO#selectActorByAge(int)
	 */
	public List<Actor> selectActorByAge(int age) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.fiap.trabalho.dao.ActorDAO#selectActorByMovie(br.com.fiap.trabalho
	 * .entity.Movie)
	 */
	public List<Actor> selectActorByMovie(Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}

}
