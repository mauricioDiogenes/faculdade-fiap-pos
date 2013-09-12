package br.com.fiap.trabalho.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String title;

	@Column
	private int yearr;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(joinColumns = @JoinColumn(name = "idMovie"), inverseJoinColumns = @JoinColumn(name = "idActor"))
	private Set<Actor> actors;

	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

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

	public void setYearr(int yearr) {
		this.yearr = yearr;
	}

}
