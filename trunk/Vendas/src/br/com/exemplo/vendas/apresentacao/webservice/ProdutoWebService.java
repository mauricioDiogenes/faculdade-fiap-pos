package br.com.exemplo.vendas.apresentacao.webservice;

import java.math.BigDecimal;

import br.com.exemplo.vendas.apresentacao.service.ServiceProduto;
import br.com.exemplo.vendas.negocio.model.vo.ProdutoVO;
import br.com.exemplo.vendas.util.exception.LayerException;

public class ProdutoWebService {
	public ProdutoVO[] listarPorPrecoEstoque() throws LayerException{
		ServiceProduto service = new ServiceProduto();
		ProdutoVO[] produtos = service.listarPorPrecoEstoque(new BigDecimal(1000), 2);
		return produtos;
	}
}
