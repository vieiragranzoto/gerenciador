package br.com.alura.gerenciador.actions;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class CadastrarEmpresa {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LocalDate ld = LocalDate.parse(request.getParameter("data"));
		Empresa em = new Empresa();
		em.setNome(request.getParameter("nome"));
		em.setData(ld);
		Banco banco = new Banco();
		banco.adiciona(em);
		
		return "redirect:entrada?acao=lista";

		// redirecionamento Client side
//		response.sendRedirect("entrada?acao=lista");

		// redirecionamento Server side
//		RequestDispatcher rd = request.getRequestDispatcher("/lista");
//		request.setAttribute("data", em.getData());
//		rd.forward(request, response);
	}

}
