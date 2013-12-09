package br.com.exemplo.vendas.negocio.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item implements Serializable{


	private static final long serialVersionUID = 1703816910654885123L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private BigInteger quantidade;

	@Column
	private BigInteger valor;

	@Column
	private String situacao;

	@Column
	private Reserva reserva;

	@Column
	private Compra comprar;

	@Column
	private Produto produto;

	public Item() {
	}

	public Item(BigInteger quantidade, BigInteger valor, String situacao,
			Reserva reserva, Compra comprar, Produto produto, Integer id) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.valor = valor;
		this.situacao = situacao;
		this.reserva = reserva;
		this.comprar = comprar;
		this.produto = produto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
