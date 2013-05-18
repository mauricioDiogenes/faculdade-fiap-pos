package br.com.fiap.javaweb.provaonline.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="questoes")
public class Questoes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Categoria categoria;
	
	@Column(nullable=false, length=2000)
	private String questao;
	
	@OneToMany(mappedBy="questao", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Alternativa> alternativas;
	
	@Column
	private boolean respondida;

	
	public boolean isRespondida() {
		return respondida;
	}

	public void setRespondida(boolean respondida) {
		this.respondida = respondida;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getQuestao() {
		return questao;
	}

	public void setQuestao(String questao) {
		this.questao = questao;
	}

	public List<Alternativa> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}
	
	
	

}
