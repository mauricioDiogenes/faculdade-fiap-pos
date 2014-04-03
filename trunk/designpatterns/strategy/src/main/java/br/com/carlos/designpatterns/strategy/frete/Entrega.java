package br.com.carlos.designpatterns.strategy.frete;


/***
 * O padrão Strategy permite definir novas operações sem alterar as classes 
 * dos elementos sobre os quais opera. Definir uma família de algoritmos e 
 * encapsular cada algoritmo como uma classe, permitindo assim que elas possam 
 * ser trocados entre si. Este padrão permite que o algoritmo possa 
 * variar independentemente dos clientes que o utilizam.
 */
public class Entrega {
	
	private CalculoFrete calculoFrete;

	public CalculoFrete getCalculoFrete() {
		return calculoFrete;
	}

	public void setCalculoFrete(CalculoFrete calculoFrete) {
		this.calculoFrete = calculoFrete;
	}
	
	

}
