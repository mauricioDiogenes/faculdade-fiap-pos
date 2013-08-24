package br.edu.fiap.jdbc.odbc;

import java.util.List;

public class BibliotecaNegocio {

	public void inserirLivro ( Livro livro, Editora editora ){
		LivroDAO livroDAO = new LivroDAO();
		livroDAO.insert(livro, editora);
	}
	public void excluirLivro ( String ISBN ){
		LivroDAO livroDAO = new LivroDAO();
		livroDAO.delete(Integer.valueOf(ISBN));
	}
	public List<Livro> selecionarTodosLivros( ){
		LivroDAO livroDAO = new LivroDAO();
		return livroDAO.list();
		
	}
	

}
