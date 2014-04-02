package br.com.fiap.pizza;

import java.io.Serializable;

public class PizzaEntity implements Serializable {

	private static final long serialVersionUID = -3466201884162565191L;
	private Integer id;
	private String nome;
	private Double valor;
	private String conteudo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

}