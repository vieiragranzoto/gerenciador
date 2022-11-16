package br.com.alura.gerenciador.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Empresa {
	private Integer id;
	private String nome;
	private LocalDate data;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalDate getData() {
		return data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
