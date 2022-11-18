package br.com.alura.gerenciador.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class ListaEmpresas implements Action{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getListaEmpresa();
		if (request.getAttribute("lista") == null) {
			request.setAttribute("lista", lista);
		}
		lista.sort((e1,e2)-> e1.getData().compareTo(e2.getData()));
		
		return "forward:WEB-INF/view/jsp/lista-empresa.jsp";
	}

}
