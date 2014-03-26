package br.com.fiap.pizzaria.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.pizzaria.bean.Pizza;
import br.com.fiap.pizzaria.dao.pizza.PizzaDao;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class PizzaServiceImpl implements PizzaService {
	
	@Inject
	private PizzaDao pizzaDao;

	@Override
	public void salvar(Pizza pizza) {
		pizzaDao.save(pizza);
	}

}
