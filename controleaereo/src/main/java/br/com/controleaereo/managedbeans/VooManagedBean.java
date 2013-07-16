package br.com.controleaereo.managedbeans;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import br.com.controleaereo.bean.Assentos;
import br.com.controleaereo.bean.Trecho;
import br.com.controleaereo.bean.Voo;
import br.com.controleaereo.bo.VooBO;

@ManagedBean(name="voo")
@ViewScoped
public class VooManagedBean {
	
	private Trecho trecho = new Trecho();
	
	private List<Trecho> trechos;
	
	private Integer assentosEconomica;
	
	private Integer assentosExecutiva;

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
		if(this.trechos == null){
			this.trechos = new ArrayList<Trecho>();
		}
		return this.trechos;
	}

	public void setTrechos(List<Trecho> trechos) {
		this.trechos = trechos;
	}

	public String cadastrarVoo(){
		if(trechos.size() != 0 && assentosEconomica != 0 && assentosExecutiva != 0){
			Mapper mapper = new DozerBeanMapper();
			Voo destObject = mapper.map(this, Voo.class);
			List<Assentos> assentos = new ArrayList<Assentos>();
			for (int i = 0; i < assentosEconomica; i++) {
				assentos.add(new Assentos("economica"));
			}
			for (int i = 0; i < assentosExecutiva; i++) {
				assentos.add(new Assentos("executiva"));
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

	public String addTrecho(){
		if(validateFields()){
			Set<Trecho> list = new LinkedHashSet<Trecho>(trechos);
			list.add(trecho);
			setTrechos(new ArrayList<Trecho>(list));
		}
		trecho = new Trecho();
		return null;
	}
	
	public String remTrecho(){
		getTrechos().remove(trecho);
		return null;
	}
	
	public boolean validateFields(){
		List<String> fields = new ArrayList<String>();
		if("".equals(trecho.getNomeTrecho1())){
			fields.add(" Origem");
		}
		if("".equals(trecho.getNomeTrecho2())){
			fields.add(" Destino");
		}
		if(trecho.getPreco() == null){
			trecho.setPreco(null);
			fields.add(" Preço");
		}
		if("".equals(trecho.getDataHora())){
			fields.add(" Data Hora");
		}
		if((!"".equals(trecho.getNomeTrecho1())) && (!"".equals(trecho.getNomeTrecho2())) && trecho.getNomeTrecho1().equals(trecho.getNomeTrecho2())){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Origem e destinos não devem ser iguais", ""));
			return false;
		}
		if(fields.size() == 0){
			return true;
		}else{
			StringBuffer msg = new StringBuffer();
			if(fields.size() > 1){
				msg.append("Preencha os campos");
			}else{
				msg.append("Preencha o campo");
			}
			for (int i = 0; i < fields.size(); i++) {
				if(i != fields.size()-1 && i != 0){
					msg.append(", ");
				}else if(i != 0){
					msg.append(" e ");
				}
				msg.append(fields.get(i));				
			}
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,msg.toString(), ""));
		}
		return false;
	}
	
	public List<Voo> getVoos(){
		List<Voo> voos = VooBO.getInstance().recuperaVoos();
		return voos;
	}
	
}