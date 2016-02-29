package br.com.uem.iss.sisnut.servico;

import java.util.List;

import br.com.uem.iss.sisnut.modelo.Paciente;
import br.com.uem.iss.sisnut.modelo.Perfil;

public interface PerfilServico {

	public void save(Perfil perfil);
	
	public List<Perfil> findAll();
}
