package br.com.controleaereo.bean;

public class Trecho {
	private String nomeTrecho1;
	private String nomeTrecho2;
	private Double preco;
	private int idVoo;

	public String getNomeTrecho1() {
		return nomeTrecho1;
	}
	public void setNomeTrecho1(String nomeTrecho1) {
		this.nomeTrecho1 = nomeTrecho1;
	}
	public String getNomeTrecho2() {
		return nomeTrecho2;
	}
	public void setNomeTrecho2(String nomeTrecho2) {
		this.nomeTrecho2 = nomeTrecho2;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public int getIdVoo() {
		return idVoo;
	}
	public void setIdVoo(int idVoo) {
		this.idVoo = idVoo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idVoo;
		result = prime * result
				+ ((nomeTrecho1 == null) ? 0 : nomeTrecho1.hashCode());
		result = prime * result
				+ ((nomeTrecho2 == null) ? 0 : nomeTrecho2.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Trecho other = (Trecho) obj;
		if (idVoo != other.idVoo) {
			return false;
		}
		if (nomeTrecho1 == null) {
			if (other.nomeTrecho1 != null) {
				return false;
			}
		} else if (!nomeTrecho1.equals(other.nomeTrecho1)) {
			return false;
		}
		if (nomeTrecho2 == null) {
			if (other.nomeTrecho2 != null) {
				return false;
			}
		} else if (!nomeTrecho2.equals(other.nomeTrecho2)) {
			return false;
		}
		if (preco == null) {
			if (other.preco != null) {
				return false;
			}
		} else if (!preco.equals(other.preco)) {
			return false;
		}
		return true;
	}
	
}
