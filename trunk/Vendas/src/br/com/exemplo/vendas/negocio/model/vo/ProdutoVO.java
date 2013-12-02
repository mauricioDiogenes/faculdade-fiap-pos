package br.com.exemplo.vendas.negocio.model.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

public class ProdutoVO implements Serializable {

	private BigInteger codigo;

	private String descricao;

	private BigDecimal preco;

	private String estoque;

	public ProdutoVO() {
	}

	public ProdutoVO(BigInteger codigo, String descricao, BigDecimal preco,
			String estoque) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
		this.estoque = estoque;
	}
	
	public ProdutoVO(BigInteger codigo){
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "ProdutoVO [codigo=" + codigo + ", descricao=" + descricao
				+ ", preco=" + preco + ", estoque=" + estoque + "]";
	}

	public BigInteger getCodigo() {
		return codigo;
	}

	public void setCodigo(BigInteger codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getEstoque() {
		return estoque;
	}

	public void setEstoque(String estoque) {
		this.estoque = estoque;
	}

}
