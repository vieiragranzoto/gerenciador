package br.com.alura.gerenciador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class MostraEmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		Banco banco = new Banco();
		Empresa emp = banco.buscaEmpresaPeloId(id);
		request.setAttribute("empresa", emp);
		request.getRequestDispatcher("/editar-empresa.jsp").forward(request, response);
	}

}
