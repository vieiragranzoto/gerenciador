package br.com.alura.gerenciador.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EfetuarLogoutUsuario implements Action {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		sessao.removeAttribute("usuario");
		sessao.invalidate();
		
		return "redirect:entrada?acao=EfetuarLoginUsuarioForm";
	}

}
