package br.com.fiap.trabalho.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.trabalho.dao.MovieDAO;
import br.com.fiap.trabalho.entity.Movie;

public class JDBCMovieDao extends JDBCConnection implements MovieDAO {

	public Movie createMovie(Movie movie) {
		try {
			String sql = "INSERT INTO MOVIE (TITLE, YEARR) VALUES (?,?)";
			PreparedStatement stm = getConnection().prepareStatement(sql);
			stm.setString(1, movie.getTitle());
			stm.setInt(2, movie.getYear());
			stm.execute();
		} catch (SQLException e) {
			movie = null;
		}
		return movie;
	}

	public boolean deleteMovie(Movie movie) {
		Boolean result = false;
		try {
			String sql = "DELETE FROM MOVIE WHERE ID=?";
			PreparedStatement stm = getConnection().prepareStatement(sql);
			stm.setInt(1, movie.getId());
			result = stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Movie> selectMoviesByTitle(String title) {
		List<Movie> movies = new ArrayList<Movie>();
		try {
			String sql = "SELECT * FROM MOVIE WHERE TITLE=?";
			PreparedStatement stm = getConnection().prepareStatement(sql);
			stm.setString(1, title);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Movie movie = new Movie();
				movie.setId(rs.getInt("ID"));
				movie.setTitle(rs.getString("TITLE"));
				movie.setYear(rs.getDate("YEARR").getDate());
				movies.add(movie);
			}
		} catch (SQLException e) {
			return movies;
		}
		return movies;
	}

	public List<Movie> selectMoviesByYear(int year) {
		List<Movie> movies = new ArrayList<Movie>();
		try {
			String sql = "SELECT * FROM MOVIE WHERE YEARR=?";
			PreparedStatement stm = getConnection().prepareStatement(sql);
			stm.setInt(1, year);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Movie movie = new Movie();
				movie.setId(rs.getInt("ID"));
				movie.setTitle(rs.getString("TITLE"));
				movie.setYear(rs.getInt("YEARR"));
				movies.add(movie);
			}
		} catch (SQLException e) {
			return movies;
		}
		return movies;
	}

	public List<Movie> selectMoviesByActorName(String actorName) {
		List<Movie> movies = new ArrayList<Movie>();
		try {
			String sql = "SELECT * FROM MOVIE M INNER JOIN MOVIE_ACTOR MA ON MA.IDMOVIE=M.ID INNER JOIN ACTOR A ON A.ID=MA.IDACTOR WHERE A.FULLNAME=?";
			PreparedStatement stm = getConnection().prepareStatement(sql);
			stm.setString(1, actorName);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Movie movie = new Movie();
				movie.setId(rs.getInt("ID"));
				movie.setTitle(rs.getString("TITLE"));
				movie.setYear(rs.getInt("YEARR"));
				movies.add(movie);
			}
		} catch (SQLException e) {
			return movies;
		}
		return movies;
	}

	public List<Movie> selectMoviesByCategoryName(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Movie> selectMoviesByStudioName(String studioName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Movie find(int id) {
		Movie movie = null;
		try {
			String sql = "SELECT * FROM MOVIE WHERE ID=?";
			PreparedStatement stm = getConnection().prepareStatement(sql);
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			rs.next();
			movie = new Movie();
			movie.setId(rs.getInt("ID"));
			movie.setTitle(rs.getString("TITLE"));
			movie.setYear(rs.getInt("YEARR"));
		} catch (SQLException e) {
			return movie;
		}
		return movie;
	}

}