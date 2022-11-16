package br.com.alura.gerenciador.actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class ListaEmpresas {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getLista();
		if (request.getAttribute("lista") == null) {
			request.setAttribute("lista", lista);
		}
		return "forward:WEB-INF/view/lista-empresa.jsp";
	}

}
