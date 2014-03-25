package br.com.fiap.pizzaria.web.controller.pizza;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("pizza")
public class PizzaController {

	@RequestMapping( value = "cadastro", method=RequestMethod.GET)
	public String init(){
		return "cadastro";
	}
	
}
