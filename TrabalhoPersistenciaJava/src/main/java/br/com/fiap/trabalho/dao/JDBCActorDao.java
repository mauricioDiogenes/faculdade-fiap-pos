package br.com.fiap.trabalho.dao;

import java.util.List;

import br.com.fiap.trabalho.entity.Actor;
import br.com.fiap.trabalho.entity.Movie;

/***
 * Classe Dao para JDBC
 * @author carlosrgomes@gmail.com
 *
 */
public class JDBCActorDao implements ActorDAO {

	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.trabalho.dao.ActorDAO#createActor(br.com.fiap.trabalho.entity.Actor)
	 */
	public Actor createActor(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.trabalho.dao.ActorDAO#deleteActor(br.com.fiap.trabalho.entity.Actor)
	 */
	public boolean deleteActor(Actor actor) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.trabalho.dao.ActorDAO#selectActorByName(java.lang.String)
	 */
	public List<Actor> selectActorByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.trabalho.dao.ActorDAO#selectActorByAge(int)
	 */
	public List<Actor> selectActorByAge(int age) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.trabalho.dao.ActorDAO#selectActorByMovie(br.com.fiap.trabalho.entity.Movie)
	 */
	public List<Actor> selectActorByMovie(Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}

}
