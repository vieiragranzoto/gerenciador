package br.com.alura.gerenciador.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/*")
public class AutorizacaoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("AutorizacaoFilter");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		HttpSession sessao = request.getSession();

		String acao = "vazio";
		if (request.getParameter("acao") != null)
			acao = request.getParameter("acao");

		if (sessao.getAttribute("usuario") != null && acao.equals("vazio")) {
			response.sendRedirect("entrada?acao=ListaEmpresas");
			return;
		}

		if (sessao.getAttribute("usuario") == null
				&& !(acao.equals("EfetuarLoginUsuario") || acao.equals("EfetuarLoginUsuarioForm"))) {
			response.sendRedirect("entrada?acao=EfetuarLoginUsuarioForm");
			return;
		}

		chain.doFilter(request, response);

	}

}
