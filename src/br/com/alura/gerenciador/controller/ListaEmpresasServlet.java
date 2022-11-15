package br.com.alura.gerenciador.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;


@WebServlet("/lista")
public class ListaEmpresasServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Banco banco = new Banco();
		List<Empresa> lista = banco.getLista();
		request.setAttribute("lista", lista);
		request.getRequestDispatcher("lista-empresa.jsp").forward(request, response);;
	}

}
