package br.com.alura.gerenciador.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class MostraEmpresa implements Action{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		Banco banco = new Banco();
		Empresa emp = banco.buscaEmpresaPeloId(id);
		request.setAttribute("empresa", emp);
		return "forward:WEB-INF/view/jsp/editar-empresa.jsp";

	}

}
