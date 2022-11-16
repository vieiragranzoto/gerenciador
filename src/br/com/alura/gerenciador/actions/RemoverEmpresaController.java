package br.com.alura.gerenciador.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;

public class RemoverEmpresaController {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		Banco banco = new Banco();
		banco.removerEmpresa(id);
		
		return "redirect:entrada?acao=lista";

	}

}
