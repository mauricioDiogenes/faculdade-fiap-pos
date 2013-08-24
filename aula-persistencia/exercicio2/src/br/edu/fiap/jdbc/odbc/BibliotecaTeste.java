package br.edu.fiap.jdbc.odbc;

import java.util.List;

public class BibliotecaTeste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria categoria = new Categoria();
		categoria.setId(1);
		categoria.setDescricao("Java");
		categoriaDAO.insert(categoria);
		
		List<Categoria> lista = categoriaDAO.list();

		for (Categoria categoria2 : lista) {
			System.out.println(categoria2.getId());
			System.out.println(categoria2.getDescricao());
		}
	}

}
