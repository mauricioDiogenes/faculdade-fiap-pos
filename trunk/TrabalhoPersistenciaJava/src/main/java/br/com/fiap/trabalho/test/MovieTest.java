package br.com.fiap.trabalho.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.fiap.trabalho.dao.AbstractDAOFactory;
import br.com.fiap.trabalho.dao.ActorDAO;
import br.com.fiap.trabalho.dao.MovieDAO;
import br.com.fiap.trabalho.dao.jpa.JPADAOFactory;
import br.com.fiap.trabalho.entity.Actor;
import br.com.fiap.trabalho.entity.Movie;

public class MovieTest {

	private static MovieDAO movieDAO;
	private static ActorDAO actorDAO;

	@BeforeClass
	public static void init() {
		AbstractDAOFactory abstractDAOFactory = new JPADAOFactory();
		movieDAO = abstractDAOFactory.createMovieDAO();
		actorDAO = abstractDAOFactory.createActorDAO();

		Actor actor1 = new Actor();
		actor1.setBirthDate(new Date("10/10/2010"));
		actor1.setFullName("actor1");
		actorDAO.createActor(actor1);

		Actor actor2 = new Actor();
		actor2.setBirthDate(new Date("10/10/2011"));
		actor2.setFullName("actor2");
		actorDAO.createActor(actor2);
		
		List<Actor> actors = new ArrayList<Actor>();
		actors.add(actor1);
		actors.add(actor2);
		
		Movie movie = new Movie();
		movie.setTitle("movie2");
		movie.setYearr(2013);
		movie.setActors(actors);
		movieDAO.createMovie(movie);

		Movie movie2 = new Movie();
		movie2.setTitle("movieDel");
		movie2.setYearr(2013);
		movie.setActors(actors);
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
		if(movieList != null){
			Movie m = movieList.get(0);
			List actors = m.getActors();
			assertNotNull(actors);	
		}
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

}
