package br.com.controleaereo.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "voo")
public class Voo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "id_voo", referencedColumnName="id", nullable=false)
	private List<Trecho> trechos;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "id_voo", referencedColumnName="id", nullable=false)
	private List<Assento> assentos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Trecho> getTrechos() {
		return trechos;
	}

	public void setTrechos(List<Trecho> trechos) {
		this.trechos = trechos;
	}

	public List<Assento> getAssentos() {
		return assentos;
	}

	public void setAssentos(List<Assento> assentos) {
		this.assentos = assentos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((assentos == null) ? 0 : assentos.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((trechos == null) ? 0 : trechos.hashCode());
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
		Voo other = (Voo) obj;
		if (assentos == null) {
			if (other.assentos != null) {
				return false;
			}
		} else if (!assentos.equals(other.assentos)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (trechos == null) {
			if (other.trechos != null) {
				return false;
			}
		} else if (!trechos.equals(other.trechos)) {
			return false;
		}
		return true;
	}

}
