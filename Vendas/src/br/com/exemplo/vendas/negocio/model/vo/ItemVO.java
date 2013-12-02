package br.com.exemplo.vendas.negocio.model.vo;

import java.io.Serializable;
import java.math.BigInteger;

import br.com.exemplo.vendas.negocio.entity.Compra;
import br.com.exemplo.vendas.negocio.entity.Produto;
import br.com.exemplo.vendas.negocio.entity.Reserva;

public class ItemVO implements Serializable {

	private BigInteger id;

	private BigInteger quantidade;

	private BigInteger valor;

	private String situacao;

	private Reserva reserva;

	private Compra comprar;

	private Produto produto;

	public ItemVO() {
	}

	public ItemVO(BigInteger quantidade, BigInteger valor, String situacao,
			Reserva reserva, Compra comprar, Produto produto, BigInteger id) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.valor = valor;
		this.situacao = situacao;
		this.reserva = reserva;
		this.comprar = comprar;
		this.produto = produto;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

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

	public Compra getComprar() {
		return comprar;
	}

	public void setComprar(Compra comprar) {
		this.comprar = comprar;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
