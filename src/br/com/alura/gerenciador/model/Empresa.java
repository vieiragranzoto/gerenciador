package br.com.alura.gerenciador.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Empresa {
	private String nome;
	private String cnpj;
	private LocalDate data;
	
	public Empresa(String nome, String cnpj, LocalDate data) {
		this.nome=nome;
		this.cnpj=cnpj;
		this.data=data;
	}
	
	public String getNome() {
		return nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public LocalDate getData() {
		return data;
	}
}
