package br.com.exemplo.vendas.negocio.model.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.exemplo.vendas.negocio.entity.Cliente;
import br.com.exemplo.vendas.negocio.entity.Compra;
import br.com.exemplo.vendas.negocio.entity.Produto;
import br.com.exemplo.vendas.negocio.entity.Reserva;

public class ReservaVO implements Serializable {

	private BigInteger codigo;

	private Date data;

	private String atendente;

	private String situacao;

	private BigDecimal valor;

	private Cliente cliente;

	public ReservaVO() {
	}

	public ReservaVO(BigInteger codigo, Date data, String atendente,
			String situacao, BigDecimal valor, Cliente cliente) {
		super();
		this.codigo = codigo;
		this.data = data;
		this.atendente = atendente;
		this.situacao = situacao;
		this.valor = valor;
		this.cliente = cliente;
	}

	public BigInteger getCodigo() {
		return codigo;
	}

	public void setCodigo(BigInteger codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getAtendente() {
		return atendente;
	}

	public void setAtendente(String atendente) {
		this.atendente = atendente;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
