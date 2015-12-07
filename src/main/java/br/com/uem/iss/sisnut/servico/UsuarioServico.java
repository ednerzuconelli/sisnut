package br.com.uem.iss.sisnut.servico;

import java.util.List;

import br.com.uem.iss.sisnut.modelo.Usuario;

public interface UsuarioServico {
	public void save(Usuario usuario);

	public List<Usuario> findAll();
}
