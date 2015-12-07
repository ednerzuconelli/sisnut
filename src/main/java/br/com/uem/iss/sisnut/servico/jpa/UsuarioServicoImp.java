package br.com.uem.iss.sisnut.servico.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.uem.iss.sisnut.controle.UsuarioControle;
import br.com.uem.iss.sisnut.modelo.Usuario;
import br.com.uem.iss.sisnut.repositorio.UsuarioRepositorio;
import br.com.uem.iss.sisnut.servico.UsuarioServico;

@Service("usuarioServico")
@Repository
@Transactional
public class UsuarioServicoImp implements UsuarioServico{

	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	@Override
	public void save(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioRepositorio.save(usuario);
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioRepositorio.findAll();
	}

}
