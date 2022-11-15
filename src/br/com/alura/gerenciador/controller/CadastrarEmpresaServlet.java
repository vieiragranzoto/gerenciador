package br.com.alura.gerenciador.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

@WebServlet("/cadastro")
public class CadastrarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LocalDate ld = LocalDate.parse(request.getParameter("data"));
		Empresa em = new Empresa(request.getParameter("nome"), request.getParameter("cnpj"), ld);
		Banco banco = new Banco();
		banco.adiciona(em);
		RequestDispatcher rd = request.getRequestDispatcher("/empresa-criada.jsp");
		request.setAttribute("nome", em.getNome());
		request.setAttribute("data", em.getData());
		rd.forward(request, response);
	}

}
