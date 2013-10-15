package br.com.exemplo.vendas.negocio.entity;

import java.math.BigInteger;

import javax.persistence.Column;

public class Produto {
	@Column
	private BigInteger quantidade;

	@Column
	private BigInteger valor;

	@Column
	private String situacao;

	@Column
	private Reserva reserva;

	@Column
	private BigInteger comprar;

	@Column
	private Produto produto;

	public BigInteger getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigInteger quantidade) {
		this.quantidade = quantidade;
	}

	public BigInteger getValor() {
		return valor;
	}

	public void setValor(BigInteger valor) {
		this.valor = valor;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public BigInteger getComprar() {
		return comprar;
	}

	public void setComprar(BigInteger comprar) {
		this.comprar = comprar;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
