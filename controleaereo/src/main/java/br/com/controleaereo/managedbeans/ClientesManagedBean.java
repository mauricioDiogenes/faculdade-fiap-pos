package br.com.controleaereo.managedbeans;

import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import br.com.controleaereo.bean.Usuario;
import br.com.controleaereo.bo.UsuarioBO;

//import org.eclipse.jetty.server.session.HashedSession;

@ManagedBean(name = "clientes")
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
		try {
			UsuarioBO.getInstance().cadastra(destObject);
		} catch (Exception e) {
			addError("Usuário já existente");
		}
		return "";
	}

	public void login(ActionEvent actionEvent) {
		Mapper mapper = new DozerBeanMapper();
		Usuario destObject = mapper.map(this, Usuario.class);
		Usuario u = UsuarioBO.getInstance().find(destObject);
		if (u == null) {
			addError("Usuário ou senha inválidos");
		} else {
			getSession().setAttribute("userSession", u);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			NavigationHandler navigationHandler = facesContext.getApplication()
					.getNavigationHandler();
			String str = "paginas/menuUsuario.jsf";
			if ("adm".equals(u.getNivel())) {
				navigationHandler.handleNavigation(facesContext, null,
						"PaginasAdm/menuAdm.jsf");
			} else {
				navigationHandler.handleNavigation(facesContext, null,
						str);
			}
		}
	}

	public String sair() {
		getSession().setAttribute("userSession", null);
		String login = "../login.jsf";
		return login;
	}

	public void addError(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, ""));
	}
}