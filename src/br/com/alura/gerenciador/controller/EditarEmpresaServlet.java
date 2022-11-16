package br.com.alura.gerenciador.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

@WebServlet("/editar")
public class EditarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		Empresa empresaEditada = banco.buscaEmpresaPeloId(Integer.valueOf(request.getParameter("id")));
		empresaEditada.setNome(request.getParameter("nome"));
		empresaEditada.setData(LocalDate.parse(request.getParameter("data")));
		response.sendRedirect("lista");
	}

}
