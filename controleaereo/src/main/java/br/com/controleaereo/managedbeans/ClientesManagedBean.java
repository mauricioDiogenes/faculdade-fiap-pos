package br.com.controleaereo.managedbeans;

import javax.faces.bean.ManagedBean;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import br.com.controleaereo.bean.Usuario;
import br.com.controleaereo.bo.UsuarioBO;

@ManagedBean(name = "usuario")
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
		Usuario destObject = mapper.map(this, Usuario.class);
		UsuarioBO.getInstance().cadastra(destObject);
		return "";
	}
}