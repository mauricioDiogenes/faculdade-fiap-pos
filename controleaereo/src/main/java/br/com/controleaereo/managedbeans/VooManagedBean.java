package br.com.controleaereo.managedbeans;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
		Set<Trecho> list = new LinkedHashSet<Trecho>(trechos);
		list.add(trecho);
		setTrechos(new ArrayList<Trecho>(list));
		trecho = new Trecho();
		return null;
	}
	
}