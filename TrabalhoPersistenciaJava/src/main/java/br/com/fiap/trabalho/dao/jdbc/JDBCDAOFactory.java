package br.com.fiap.trabalho.dao.jdbc;

import br.com.fiap.trabalho.dao.AbstractDAOFactory;
import br.com.fiap.trabalho.dao.ActorDAO;
import br.com.fiap.trabalho.dao.CategoryDAO;
import br.com.fiap.trabalho.dao.MovieDAO;
import br.com.fiap.trabalho.dao.StudioDAO;

public class JDBCDAOFactory extends AbstractDAOFactory {

	@Override
	public MovieDAO createMovieDAO() {
		return new JDBCMovieDao();
	}

	@Override
	public ActorDAO createActorDAO() {
		return new JDBCActorDAO();
	}

	@Override
	public CategoryDAO createCategoryDAO() {
		return null;
	}

	@Override
	public StudioDAO createStudioDAO() {
		return null;
	}
}
