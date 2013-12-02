package br.com.exemplo.vendas.negocio.model.vo ;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import br.com.exemplo.vendas.negocio.entity.Cliente;
import br.com.exemplo.vendas.negocio.entity.Reserva;

public class CompraVO implements Serializable
{
	private BigInteger numero;
	private Date data;
	private String responsavel;
	private String situacao;
	private BigDecimal valor;
	private Reserva reserva;
	private Cliente cliente;

	public CompraVO( )
	{
	}

	public CompraVO(BigInteger numero){
		this.numero = numero;
	}
	
	public CompraVO(BigInteger numero, Date data, String responsavel,
			String situacao, BigDecimal valor, Reserva reserva, Cliente cliente) {
		super();
		this.numero = numero;
		this.data = data;
		this.responsavel = responsavel;
		this.situacao = situacao;
		this.valor = valor;
		this.reserva = reserva;
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "CompraVO [numero=" + numero + ", data=" + data
				+ ", responsavel=" + responsavel + ", situacao=" + situacao
				+ ", valor=" + valor + ", reserva=" + reserva + ", cliente="
				+ cliente + "]";
	}
	

	public BigInteger getNumero() {
		return numero;
	}

	public void setNumero(BigInteger numero) {
		this.numero = numero;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
