package br.com.fiap.aop.regras;

import java.util.List;

import br.com.fiap.atividade.bean.Pedido;
import br.com.fiap.atividade.util.UtilCalculo;

public aspect RegraDeNegocio {
	
	private Double novoValor = 0d;
	
	pointcut vendaMaiorQue1000() : call( private * br.com.fiap.atividade.service.PedidoService.somar(..));

	after() returning(Double r)  : vendaMaiorQue1000() {
		Double val =  r;
		Object[] objetos = thisJoinPoint.getArgs();
		@SuppressWarnings("unchecked")
		List<Pedido> lisPedidos = (List<Pedido>) objetos[0];
		regraDeNegocio(val, lisPedidos);
		
	}

	private void regraDeNegocio(Double val, List<Pedido> lisPedidos) {
		//Venda maior que R$1000
		if(val > 1000d){
			for (Pedido pedido : lisPedidos) {
				Double valorComDesconto = pedido.getValorUnitario() - UtilCalculo.calcular(pedido.getValorUnitario(), 5.0);
				novoValor += valorComDesconto;
				pedido.setDesconto(valorComDesconto);
			}
			
		}
		//Compras acima de 10 itens.
		else if(lisPedidos.size() > 10){
			Double valor10Itens = 0d;
			for (Pedido pedido : lisPedidos) {
				 valor10Itens += pedido.getValorUnitario();
			}
			
		 novoValor = (valor10Itens - UtilCalculo.calcular(valor10Itens, 5.0d));
		}
	}
	
	Object around() : vendaMaiorQue1000(){
		proceed();
		return new Double(novoValor);
	}
	
	
	
	
}
