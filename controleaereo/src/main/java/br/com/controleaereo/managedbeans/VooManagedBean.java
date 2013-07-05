package br.com.controleaereo.managedbeans;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.controleaereo.bean.Trecho;

@ManagedBean(name="voo")
@ViewScoped
public class VooManagedBean {
	
	private Trecho trecho = new Trecho();
	
	private double valorTotal;
	
	private static List<Trecho> trechos;

	public Trecho getTrecho() {
		return trecho;
	}

	public void setTrecho(Trecho trecho) {
		this.trecho = trecho;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Trecho> getTrechos() {
		if(VooManagedBean.trechos == null){
			VooManagedBean.trechos = new ArrayList<Trecho>();
		}
		return VooManagedBean.trechos;
	}

	public void setTrechos(List<Trecho> trechos) {
		VooManagedBean.trechos = trechos;
	}

	public String cadastrar(){
		return "../login.faces";
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
}