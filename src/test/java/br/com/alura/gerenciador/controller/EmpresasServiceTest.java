package br.com.alura.gerenciador.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.junit.jupiter.api.Test;

public class EmpresasServiceTest {

	private String conteudo;

	@Test
	public void clienteWebServiceTipoNaoexpecificado() throws ClientProtocolException, IOException {
			this.conteudo = Request.Post("http://localhost:8080/gerenciador/empresas")
					.addHeader("Accepet", "application/ ").execute().returnContent().asString();
			assertEquals("{'message':'no content'}", this.conteudo);
	}
}
