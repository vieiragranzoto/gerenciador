package br.com.alura.gerenciador.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Usuario;

public class EfetuarLoginUsuario implements Action{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Banco banco = new Banco();
		
		Usuario usuario = banco.buscarUsuario(request.getParameter("nome"), request.getParameter("senha"));
		
		if(usuario!=null)
			return "redirect:entrada?acao=ListaEmpresas";
		
		request.setAttribute("usuarioIncorreto", true);
		
		return "forward:WEB-INF/view/jsp/efetuar-login.jsp";
	}

}
