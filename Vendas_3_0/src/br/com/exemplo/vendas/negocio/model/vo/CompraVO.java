package br.com.exemplo.vendas.negocio.model.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CompraVO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Integer numero ;
	private Date data ;
	private String responsavel ;
	private String situacao ;
	private BigDecimal valor ;
	private int reserva ;
	private int cliente ;

	public String toString( )
	{
		return  this.numero + ":" + this.data + ":" + this.responsavel + ":" + this.situacao + ":" + this.valor + ":" + this.reserva + ":" + this.cliente;

	}

	public CompraVO()
	{

	}

	public CompraVO( Integer numero, Date data, String responsavel, String situacao, BigDecimal valor, int reserva, int cliente )
	{
		this.numero = numero ;
		this.data = data ;
		this.responsavel = responsavel ;
		this.situacao = situacao ;
		this.valor = valor ;
		this.reserva = reserva ;
		this.cliente = cliente ;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente( int cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public int getReserva() {
		return reserva;
	}

	public void setReserva( int reserva) {
		this.reserva = reserva;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
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

}
