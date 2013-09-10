package br.com.fiap.trabalho.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable=false)
	private String title;

	@Column(nullable=false)
	private int yearr;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Category category;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Studio studio;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="movie_actor",
		joinColumns = @JoinColumn(name="idMovie", referencedColumnName="id"),
		inverseJoinColumns = @JoinColumn(name="idActor")
	)
	private List<Actor> actors;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYearr() {
		return yearr;
	}

	public void setYearr(int year) {
		this.yearr = year;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Studio getStudio() {
		return studio;
	}

	public void setStudio(Studio studio) {
		this.studio = studio;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
}
