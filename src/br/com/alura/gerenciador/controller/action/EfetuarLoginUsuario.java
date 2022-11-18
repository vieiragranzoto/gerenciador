package br.com.alura.gerenciador.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Usuario;

public class EfetuarLoginUsuario implements Action{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Banco banco = new Banco();
		
		Usuario usuario = banco.buscarUsuario(request.getParameter("nome"), request.getParameter("senha"));
		
		if(usuario!=null) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuario", usuario);
			return "redirect:entrada?acao=ListaEmpresas";
		}
		
		request.setAttribute("incorreto", true);
		return "forward:WEB-INF/view/jsp/efetuar-login.jsp";
	}

}
