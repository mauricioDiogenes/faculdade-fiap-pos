package br.com.fiap.trabalho.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fiap.trabalho.dao.AbstractDAOFactory;
import br.com.fiap.trabalho.dao.MovieDAO;
import br.com.fiap.trabalho.dao.jpa.JPADAOFactory;
import br.com.fiap.trabalho.entity.Actor;
import br.com.fiap.trabalho.entity.Movie;

public class TestJPAMovieDao {
	private MovieDAO movieDAO;

	@Before
	public void init() {
		AbstractDAOFactory abstractDAOFactory = new JPADAOFactory();
		movieDAO = abstractDAOFactory.createMovieDAO();
		
		Actor actor = new Actor();
		actor.setBirthDate(new Date("10/10/2012"));
		actor.setFullName("actor1");
		
		Actor actor2 = new Actor();
		actor2.setBirthDate(new Date("10/10/2011"));
		actor2.setFullName("actor2");
		
		List actors = new ArrayList();
		actors.add(actor);
		actors.add(actor2);
		
		Movie movie = new Movie();
		movie.setTitle("movie select");
		movie.setYearr(2013);
		movie.setActors(actors);
		movieDAO.createMovie(movie);
		
		Movie movie2 = new Movie();
		movie2.setTitle("movieDel");
		movie2.setYearr(2013);
		movieDAO.createMovie(movie2);
	}

	@Test
	public void validarcreateDao() {
		Assert.assertNotNull(this.movieDAO);
	}

	@Test
	public void selectActorByTitle() {
		List<Movie> movieList = movieDAO.selectMoviesByTitle("movie select");
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
		movie.setYearr(2013);
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
	
	@Test
	public void selectMovieByActor(){
		List<Movie> movies = movieDAO.selectMoviesByActorName("actor1");
		assertNotNull(movies);
	}
}
