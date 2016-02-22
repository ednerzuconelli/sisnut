package br.com.uem.iss.sisnut.servico.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.uem.iss.sisnut.modelo.Perfil;
import br.com.uem.iss.sisnut.repositorio.PerfilRepositorio;
import br.com.uem.iss.sisnut.servico.PerfilServico;

@Service("perfilServico")
@Repository
@Transactional
public class PerfilServicoImp implements PerfilServico {

	@Autowired
	private PerfilRepositorio perfilRepositorio;

	@Transactional
	@Override
	public void save(Perfil perfil) {
		perfilRepositorio.save(perfil);
		
	}

	@Transactional(readOnly=true)
	@Override
	public List<Perfil> findAll() {
		
		return (List<Perfil>) perfilRepositorio.findAll();
	}
	
}
