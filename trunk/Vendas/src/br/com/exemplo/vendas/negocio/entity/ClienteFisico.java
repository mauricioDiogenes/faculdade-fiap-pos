package br.com.exemplo.vendas.negocio.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cliente_fisico")
public class ClienteFisico extends Cliente implements Serializable {

	private static final long serialVersionUID = -6238863104603472348L;

	@Column
	private String RG;
	
	@Column
	private String CPF;

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

}
