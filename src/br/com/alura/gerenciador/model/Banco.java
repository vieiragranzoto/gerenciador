package br.com.alura.gerenciador.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	private static List<Empresa> listaEmpresa = new ArrayList<Empresa>();
	private static List<Usuario> listaUsuario = new ArrayList<Usuario>();
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

		listaEmpresa.add(empresa);
		listaEmpresa.add(empresa2);

		Usuario u1 = new Usuario();
		u1.setLogin("user");
		u1.setSenha("");

		Usuario u2 = new Usuario();
		u2.setLogin("admin");
		u2.setSenha("admin");
		
		listaUsuario.add(u1);
		listaUsuario.add(u2);
	}

	public List<Empresa> getListaEmpresa() {
		return Banco.listaEmpresa;
	}

	public void adicionaEmpresa(Empresa e) {
		e.setId(chaveSequencial++);
		Banco.listaEmpresa.add(e);
	}

	public void removerEmpresa(Integer id) {
		Iterator<Empresa> it = listaEmpresa.iterator();
		while (it.hasNext()) {
			Empresa emp = it.next();
			if (emp.getId() == id) {
				it.remove();
			}
		}
	}

	public Empresa buscaEmpresaPeloId(Integer id) {
		for (Empresa empresa : listaEmpresa) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}
	
	public static List<Usuario> getListaUsuario() {
		return Banco.listaUsuario;
	}

	public Usuario buscarUsuario(String nome, String senha) {
		for (Usuario usuario : listaUsuario) {
			if(usuario.ehIgual(nome, senha)) {
				return usuario;
			}
		}
		return null;
	}
}
