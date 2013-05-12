package br.com.fiap.javaweb.provaonline.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="alternativa")
public class Alternativa {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(length=2000)
	private String altervativa;
	
	@Column
	private Boolean correta;
	
	@ManyToOne
	private Questoes questao;
	
	public Questoes getQuestao() {
		return questao;
	}

	public void setQuestao(Questoes questao) {
		this.questao = questao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAltervativa() {
		return altervativa;
	}

	public void setAltervativa(String altervativa) {
		this.altervativa = altervativa;
	}

	public Boolean getCorreta() {
		return correta;
	}

	public void setCorreta(Boolean correta) {
		this.correta = correta;
	}


}
