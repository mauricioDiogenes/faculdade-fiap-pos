package br.com.controleaereo.managedbeans;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import br.com.controleaereo.bean.Assento;
import br.com.controleaereo.bean.Trecho;
import br.com.controleaereo.bean.Usuario;
import br.com.controleaereo.bean.Voo;
import br.com.controleaereo.bo.VooBO;

@ManagedBean(name = "voo")
@SessionScoped
public class VooManagedBean {

	private HttpSession getSession() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return session;
	}

	private Trecho trecho = new Trecho();

	private Voo voo;
	
	private List<Trecho> trechos;

	private List<Assento> assentos;

	private Integer assentosEconomica;

	private Integer assentosExecutiva;

	private String selectedAssentos;

	private List<Assento> assentoList;

	
	public Voo getVoo() {
		return voo;
	}

	public void setVoo(Voo voo) {
		this.voo = voo;
	}

	public List<Assento> getAssentos() {
		return assentos;
	}

	public void setAssentos(List<Assento> assentos) {
		this.assentos = assentos;
	}

	public String getSelectedAssentos() {
		return selectedAssentos;
	}

	public void setSelectedAssentos(String selectedAssentos) {
		this.selectedAssentos = selectedAssentos;
	}

	public Integer getAssentosEconomica() {
		return assentosEconomica;
	}

	public void setAssentosEconomica(Integer assentosEconomica) {
		this.assentosEconomica = assentosEconomica;
	}

	public Integer getAssentosExecutiva() {
		return assentosExecutiva;
	}

	public void setAssentosExecutiva(Integer assentosExecutiva) {
		this.assentosExecutiva = assentosExecutiva;
	}

	public Trecho getTrecho() {
		return trecho;
	}

	public void setTrecho(Trecho trecho) {
		this.trecho = trecho;
	}

	public List<Trecho> getTrechos() {
		if (this.trechos == null) {
			this.trechos = new ArrayList<Trecho>();
		}
		return this.trechos;
	}

	public void setTrechos(List<Trecho> trechos) {
		this.trechos = trechos;
	}

	public String cadastrarVoo() {
		if (trechos.size() != 0 && assentosEconomica != 0
				&& assentosExecutiva != 0) {
			Mapper mapper = new DozerBeanMapper();
			Voo destObject = mapper.map(this, Voo.class);
			List<Assento> assentos = new ArrayList<Assento>();
			for (int i = 0; i < assentosEconomica; i++) {
				assentos.add(new Assento("economica"));
			}
			for (int i = 0; i < assentosExecutiva; i++) {
				assentos.add(new Assento("executiva"));
			}
			destObject.setAssentos(assentos);
			try {
				VooBO.getInstance().cadastra(destObject);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "CadastroVoo.jsf";
	}

	public String addTrecho() {
		if (validateFields()) {
			Set<Trecho> list = new LinkedHashSet<Trecho>(trechos);
			list.add(trecho);
			setTrechos(new ArrayList<Trecho>(list));
		}
		trecho = new Trecho();
		return null;
	}

	public String remTrecho() {
		getTrechos().remove(trecho);
		return null;
	}

	public boolean validateFields() {
		List<String> fields = new ArrayList<String>();
		if ("".equals(trecho.getNomeTrecho1())) {
			fields.add(" Origem");
		}
		if ("".equals(trecho.getNomeTrecho2())) {
			fields.add(" Destino");
		}
		if (trecho.getPreco() == null) {
			trecho.setPreco(null);
			fields.add(" Preço");
		}
		if ("".equals(trecho.getDataHora())) {
			fields.add(" Data Hora");
		}
		if ((!"".equals(trecho.getNomeTrecho1()))
				&& (!"".equals(trecho.getNomeTrecho2()))
				&& trecho.getNomeTrecho1().equals(trecho.getNomeTrecho2())) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Origem e destinos não devem ser iguais", ""));
			return false;
		}
		if (fields.size() == 0) {
			return true;
		} else {
			StringBuffer msg = new StringBuffer();
			if (fields.size() > 1) {
				msg.append("Preencha os campos");
			} else {
				msg.append("Preencha o campo");
			}
			for (int i = 0; i < fields.size(); i++) {
				if (i != fields.size() - 1 && i != 0) {
					msg.append(", ");
				} else if (i != 0) {
					msg.append(" e ");
				}
				msg.append(fields.get(i));
			}
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, msg
							.toString(), ""));
		}
		return false;
	}

	public List<Voo> getVoos() {
		List<Voo> voos = VooBO.getInstance().recuperaVoos();
		return voos;
	}

	public Voo getVooById() {
		Voo voo = null;
		Map<String, String> params = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		if (params.get("voo") != null) {
			voo = VooBO.getInstance().recuperaVoo(new Long(params.get("voo")));
			setVoo(voo);
		}
		return voo;
	}

	public List<Assento> getAssentoList() {
		Map<String, String> params = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		Usuario u = (Usuario) getSession().getAttribute("userSession");
		List<Assento> assentosList = VooBO.getInstance()
				.recuperaAssentosDisponiveis(u, getVoo().getId());
		setAssentos(assentosList);
		return assentos;
	}

	public void setAssentoList(List<Assento> s) {
		this.assentoList = s;
	}

	public String reservar() {
		Usuario u = (Usuario) getSession().getAttribute("userSession");
		String[] selecteds = selectedAssentos.split(",");
		VooBO.getInstance().reservar(u, getAssentos(), selecteds);
		return "confirmacao.jsf";
	}

}