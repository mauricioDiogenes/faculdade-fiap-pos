package br.com.fiap.trabalho.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.fiap.trabalho.dao.AbstractDAOFactory;
import br.com.fiap.trabalho.dao.MovieDAO;
import br.com.fiap.trabalho.dao.jpa.JPADAOFactory;
import br.com.fiap.trabalho.entity.Actor;
import br.com.fiap.trabalho.entity.Movie;

public class MovieTest {

	private MovieDAO movieDAO;

	@BeforeClass
	public void init() {
		AbstractDAOFactory abstractDAOFactory = new JPADAOFactory();
		movieDAO = abstractDAOFactory.createMovieDAO();
		Movie movie = new Movie();
		movie.setTitle("movie2");
		movie.setYear(2013);
		movieDAO.createMovie(movie);

		Movie movie2 = new Movie();
		movie2.setTitle("movieDel");
		movie2.setYear(2013);
		movieDAO.createMovie(movie2);
	}

	@Test
	public void selectActorByTitle() {
		List<Movie> movieList = movieDAO.selectMoviesByTitle("movie2");
		assertNotNull(movieList);
	}

	@Test
	public void selectMovieByYear() {
		List<Movie> movieList = movieDAO.selectMoviesByYear(2013);
		assertNotNull(movieList);
	}

	@Test
	public void insertMovie() {
		Movie movie = new Movie();
		movie.setTitle("movie1");
		movie.setYear(2013);
		Movie m = movieDAO.createMovie(movie);
		assertNotNull(m);
	}

	@Test
	public void deleteMovie() {
		List<Movie> movieList = movieDAO.selectMoviesByTitle("movieDel");
		movieDAO.deleteMovie(movieList.get(0));
		List<Movie> movieList2 = movieDAO.selectMoviesByTitle("movieDel");
		assertTrue(movieList2.isEmpty());
	}
}
