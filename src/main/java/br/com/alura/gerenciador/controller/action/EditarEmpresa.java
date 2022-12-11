package br.com.alura.gerenciador.controller.action;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class EditarEmpresa implements Action{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Banco banco = new Banco();
		Empresa empresaEditada = banco.buscaEmpresaPeloId(Integer.valueOf(request.getParameter("id")));
		empresaEditada.setNome(request.getParameter("nome"));
		empresaEditada.setData(LocalDate.parse(request.getParameter("data")));
		
		return "redirect:entrada?acao=ListaEmpresas";

	}

}
