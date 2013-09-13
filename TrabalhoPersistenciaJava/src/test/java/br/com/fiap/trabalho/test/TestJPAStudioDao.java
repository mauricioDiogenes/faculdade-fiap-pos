package br.com.fiap.trabalho.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.derby.tools.sysinfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fiap.trabalho.dao.AbstractDAOFactory;
import br.com.fiap.trabalho.dao.StudioDAO;
import br.com.fiap.trabalho.dao.jpa.JPADAOFactory;
import br.com.fiap.trabalho.entity.Actor;
import br.com.fiap.trabalho.entity.Movie;
import br.com.fiap.trabalho.entity.Studio;

public class TestJPAStudioDao {
	private static StudioDAO studioDAO;

	@Before
	public void init() {
		AbstractDAOFactory abstractDAOFactory = new JPADAOFactory();
		studioDAO = abstractDAOFactory.createStudioDAO();
		Studio studio1 = new Studio();
		studio1.setName("Studio 1");
		
		Actor actor = new Actor();
		actor.setBirthDate(new Date("10/10/2012"));
		actor.setFullName("actor1 movie");
		
		Actor actor2 = new Actor();
		actor2.setBirthDate(new Date("10/10/2011"));
		actor2.setFullName("actor2 movie");
		
		Set<Actor> actors = new HashSet<Actor>();
		actors.add(actor);
		actors.add(actor2);
		
		Movie movie = new Movie();
		movie.setTitle("movie select");
		movie.setYear(2013);
		movie.setActors(actors);
		
		Set<Movie> movies = new HashSet<Movie>();
		movies.add(movie);
		studio1.setMovies(movies);
		studioDAO.createStudio(studio1);
	}

	@Test
	public void validarcreateDao() {
		Assert.assertNotNull(this.studioDAO);
	}
	
	@Test
	public void insertStudio(){
		Studio studio = new Studio();
		studio.setName("Studio Insert");
		Studio c = studioDAO.createStudio(studio);
		assertNotNull(c);
	}
	
	@Test
	public void selectStudioByName(){
		List<Studio> studios = studioDAO.selectStudioByName("Studio 1");
		assertNotNull(studios);
	}
	
}
