package br.com.alura.gerenciador.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	private static List<Empresa> lista=new ArrayList<Empresa>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Alura");
		empresa.setData(LocalDate.of(2007, 01, 01));
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Babbel");
		empresa2.setData(LocalDate.of(2013, 06, 01));
		lista.add(empresa);
		lista.add(empresa2);
	}
	public List<Empresa> getLista() {
		return Banco.lista;
	}
	public void adiciona(Empresa e) {
		e.setId(chaveSequencial++);
		Banco.lista.add(e);
	}
	public void removerEmpresa(Integer id) {
		Iterator<Empresa> it = lista.iterator();
		while(it.hasNext()) {
			Empresa emp = it.next();
			if(emp.getId()==id) {
				it.remove();
			}
		}
	}
	public Empresa buscaEmpresaPeloId(Integer id) {
		for (Empresa empresa : lista) {
			if(empresa.getId()==id) {
				return empresa;
			}
		}
		return null;
	}
}