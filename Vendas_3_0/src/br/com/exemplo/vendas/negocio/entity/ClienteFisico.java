package br.com.exemplo.vendas.negocio.entity;

import javax.persistence.Column;

public class ClienteFisico extends Cliente {
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
