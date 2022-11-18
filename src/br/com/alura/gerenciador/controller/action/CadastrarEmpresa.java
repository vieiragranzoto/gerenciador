package br.com.alura.gerenciador.controller.action;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class CadastrarEmpresa implements Action{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LocalDate ld = LocalDate.parse(request.getParameter("data"));
		Empresa em = new Empresa();
		em.setNome(request.getParameter("nome"));
		em.setData(ld);
		Banco banco = new Banco();
		banco.adicionaEmpresa(em);
		
		return "redirect:entrada?acao=ListaEmpresas";

		// redirecionamento Client side
//		response.sendRedirect("entrada?acao=lista");

		// redirecionamento Server side
//		RequestDispatcher rd = request.getRequestDispatcher("/lista");
//		request.setAttribute("data", em.getData());
//		rd.forward(request, response);
	}

}
