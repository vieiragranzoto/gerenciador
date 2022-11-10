package br.com.alura.gerenciador.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Empresa em = new Empresa(req.getParameter("nome"), req.getParameter("cnpj"));
		Banco banco = new Banco();
		banco.adiciona(em);
		PrintWriter out = res.getWriter();
		out.println(
				"<html>"
				+ "<head>"
				+ "<style>"
				+ "html,body{color:white;background-color:black;}</style></head>"
				+ "<body>"
				+ "Empresa: "
				+ em.getNome()
				+" cadastrada com sucesso!"
				+ "</body>"
				+ "</html>");
	}

}
