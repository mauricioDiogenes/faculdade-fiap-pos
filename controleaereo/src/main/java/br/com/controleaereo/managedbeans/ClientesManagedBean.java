package br.com.controleaereo.managedbeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import br.com.controleaereo.bean.Usuario;
import br.com.controleaereo.bo.UsuarioBO;

//import org.eclipse.jetty.server.session.HashedSession;

@ManagedBean(name = "usuario")
public class ClientesManagedBean {
	private String email;
	private String senha;

	private HttpSession getSession() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return session;
	}

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

	public String redireciona() {
		if (getSession().getAttribute("userSession") != null) {
			return "paginas/index.faces";
		} else {
			return null;
		}
	}

	public void login(ActionEvent actionEvent) {
		Mapper mapper = new DozerBeanMapper();
		Usuario destObject = mapper.map(this, Usuario.class);
		Usuario u = UsuarioBO.getInstance().find(destObject);
		if (u == null) {
			addError(actionEvent);
		} else {
			getSession().setAttribute("userSession", u);
		}

	}

	public void addError(ActionEvent actionEvent) {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Usuário ou senha inválidos", ""));
	}
}