package br.com.alura.gerenciador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.actions.CadastrarEmpresa;
import br.com.alura.gerenciador.actions.EditarEmpresaController;
import br.com.alura.gerenciador.actions.ListaEmpresasController;
import br.com.alura.gerenciador.actions.MostraEmpresaController;
import br.com.alura.gerenciador.actions.RemoverEmpresaController;

@WebServlet("/")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("acao")==null) {
			System.out.println("Acao null - request");
			request.getRequestDispatcher("WEB-INF/view/lista-empresa.jsp")
			.forward(request, response);
		}else {
			String paramAcao =request.getParameter("acao");
			try {
				paramAcao = request.getParameter("acao");
			}catch(NullPointerException ex) {
				
			}
			paramAcao = request.getParameter("acao");
			String redireciona = "";
			if(paramAcao.equals("lista")) {
				System.out.print("lista - ");
				ListaEmpresasController lec = new ListaEmpresasController();
				redireciona = lec.executa(request, response);
			}
			else if(paramAcao.equals("novoCadastro")) {
				System.out.print("novoCadastro - ");
				redireciona = "forward:WEB-INF/view/form-empresa.jsp";
			}
			else if(paramAcao.equals("cadastro")) {
				System.out.print("cadastro - ");
				CadastrarEmpresa cec = new CadastrarEmpresa();
				redireciona = cec.executa(request, response);
			}
			else if(paramAcao.equals("remover")) {
				System.out.print("remover - ");
				RemoverEmpresaController rec = new RemoverEmpresaController();
				redireciona = rec.executa(request, response);
			}
			else if(paramAcao.equals("editar")) {
				System.out.print("editar - ");
				EditarEmpresaController eec = new EditarEmpresaController();
				redireciona = eec.executa(request, response);
			}
			else if(paramAcao.equals("mostrar")) {
				System.out.print("mostrar - ");
				MostraEmpresaController mec = new MostraEmpresaController();
				redireciona =mec.executa(request, response);
			}
			String[] tipo = redireciona.split(":");
			if(tipo[0].equals("forward")) {
				System.out.println("request");
				request.getRequestDispatcher(tipo[1])
				.forward(request, response);
			} else {
				System.out.println("response");
				response.sendRedirect(tipo[1]);
			}
		}
	}

}
