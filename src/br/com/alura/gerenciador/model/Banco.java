package br.com.alura.gerenciador.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Banco {
	private static List<Empresa> lista=new ArrayList<Empresa>();

	public List<Empresa> getLista() {
		return Banco.lista;
	}
	public void adiciona(Empresa e) {
		Banco.lista.add(e);
	}
}
