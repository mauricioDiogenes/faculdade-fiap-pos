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
@WebServlet("/paginas/prova")
public class ProvaServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoriaDaoImpl categoriaDaoImpl;
	
	@Inject
	private PerguntasDaoImpl perguntasDaoImpl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProvaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Questoes> listaQuestoes = perguntasDaoImpl.listAll();
		request.setAttribute("questoes", listaQuestoes);
		request.getSession().setAttribute("questoes", listaQuestoes);
		response.sendRedirect("prova.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		for(int j=0;j<request.getParameterMap().size();j++){
			String resposta = request.getParameter("questao"+(j+1));
			System.out.println(resposta);
		}
	}

}
