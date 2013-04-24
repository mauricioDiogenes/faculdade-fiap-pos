package br.com.barbero.autoatendimento.dao;

import java.math.BigDecimal;

import br.com.barbero.autoatendimento.bean.Cliente;


public interface GenericDAO<T> {
	
	public T consultar(Long id);
	public void depositar(Cliente cliente, BigDecimal valorDepositor);

}
