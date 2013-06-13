package br.com.controleaereo.managedbeans;

import javax.faces.bean.ManagedBean;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import br.com.controleaereo.bean.Cliente;
import br.com.controleaereo.bo.ClienteBO;

@ManagedBean(name = "clientes")
public class ClientesManagedBean {
	private String email;
	private String senha;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String cadastrar() {
		Mapper mapper = new DozerBeanMapper();
		Cliente destObject = mapper.map(this, Cliente.class);
		ClienteBO.getInstance().cadastra(destObject);
		return "";
	}
}