package br.com.fiap.javaweb.provaonline.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.javaweb.provaonline.bean.Alternativa;
import br.com.fiap.javaweb.provaonline.bean.Categoria;
import br.com.fiap.javaweb.provaonline.bean.Questoes;
import br.com.fiap.javaweb.provaonline.dao.CategoriaDaoImpl;
import br.com.fiap.javaweb.provaonline.dao.PerguntasDaoImpl;

/**
 * Servlet implementation class CadastrarPerguntasServlet
 */
@WebServlet("/paginas/CadastrarPerguntas")
public class CadastrarPerguntasServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoriaDaoImpl categoriaDaoImpl;
	
	@Inject
	private PerguntasDaoImpl perguntasDaoImpl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarPerguntasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categoria> categoria  = categoriaDaoImpl.listAll();
		request.setAttribute("listaCategoria", categoria);
		request.getRequestDispatcher("cadastrarPerguntas.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Questoes questoes = new Questoes();
		questoes.setQuestao(request.getParameter("questao"));
		Categoria categoria = categoriaDaoImpl.find(Long.parseLong(request.getParameter("categoria")));
		Alternativa alternativa1 = new Alternativa();
		alternativa1.setAltervativa(request.getParameter("alternativa1"));
		List<Alternativa> alternativas = new ArrayList<Alternativa>();
		alternativas.add(alternativa1);
		questoes.setAlternativas(alternativas);
		questoes.setCategoria(categoria);
		perguntasDaoImpl.save(questoes);
		List<Questoes> listaQuestoes =  perguntasDaoImpl.listAll();
		request.setAttribute("listaQuestoes", listaQuestoes);
		request.getRequestDispatcher("cadastrarPerguntas.jsp").forward(request, response);
		
	}

}
