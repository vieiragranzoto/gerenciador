package br.com.alura.gerenciador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.controller.action.Action;

@WebServlet("/")
public class EntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String paramAcao = "vazio", redireciona, nomeDaClasse;

		try {
			
			if(request.getParameter("acao")!=null)
				paramAcao = request.getParameter("acao");
	
			HttpSession sessao = request.getSession();
			
			if(sessao.getAttribute("usuario") == null && !paramAcao.equals("EfetuarLoginUsuario"))
				paramAcao = "EfetuarLoginUsuarioForm";
			
			if(sessao.getAttribute("usuario") != null && paramAcao.equals("vazio"))
				paramAcao = "ListaEmpresas";

			nomeDaClasse = "br.com.alura.gerenciador.controller.action." + paramAcao;
			@SuppressWarnings("rawtypes")
			Class classe = Class.forName(nomeDaClasse);
			Action act = (Action) classe.newInstance();
			redireciona = act.executa(request, response);

			String[] tipo = redireciona.split(":");

			if (tipo[0].equals("forward"))
				request.getRequestDispatcher(tipo[1]).forward(request, response);
			else
				response.sendRedirect(tipo[1]);
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NullPointerException e) {
			throw new ServletException(e);
		}
		
	}
}
