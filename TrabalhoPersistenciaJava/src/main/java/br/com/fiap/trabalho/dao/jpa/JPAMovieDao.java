package br.com.fiap.trabalho.dao.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.fiap.trabalho.dao.MovieDAO;
import br.com.fiap.trabalho.entity.Movie;

public class JPAMovieDao extends JPAConnection implements MovieDAO {

	public Movie createMovie(Movie movie) {
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(movie);
		getEntityManager().getTransaction().commit();
		return movie;
	}

	public boolean deleteMovie(Movie movie) {
		getEntityManager().getTransaction().begin();
		getEntityManager().remove(movie);
		getEntityManager().getTransaction().commit();
		return true;
	}

	public List<Movie> selectMoviesByTitle(String title) {
		TypedQuery<Movie> query = getEntityManager().createQuery(
				"SELECT M FROM Movie M WHERE title = :title", Movie.class);
		query.setParameter("title", title);
		return (List<Movie>) query.getResultList();
	}

	public List<Movie> selectMoviesByYear(int year) {
		TypedQuery<Movie> query = getEntityManager().createQuery(
				"SELECT m FROM Movie m WHERE yearr = :ano", Movie.class);
		query.setParameter("ano", year);

		return (List<Movie>) query.getResultList();
	}

	public List<Movie> selecMoviesByActorName(String actorName) {
		TypedQuery<Movie> query = getEntityManager().createQuery(
				"SELECT m FROM Movie m INNER JOIN m.actor", Movie.class);
		return null;
	}

	public List<Movie> selectMoviesByCategoryName(String categoryName) {
		return null;
	}

	public List<Movie> selectMoviesByStudioName(String studioName) {
		return null;
	}

}
