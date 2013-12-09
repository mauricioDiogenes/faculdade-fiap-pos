package br.com.exemplo.vendas.negocio.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="cliente_juridico")
public class ClienteJuridico extends Cliente implements Serializable {

	private static final long serialVersionUID = -3831500280786803770L;

	@Column
	private String CNPJ;
	
	@Column
	private String IE;

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getIE() {
		return IE;
	}

	public void setIE(String iE) {
		IE = iE;
	}
}
