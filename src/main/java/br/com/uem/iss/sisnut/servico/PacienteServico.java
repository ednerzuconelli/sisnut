package br.com.uem.iss.sisnut.servico;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.uem.iss.sisnut.modelo.Paciente;
import br.com.uem.iss.sisnut.modelo.Usuario;



public interface PacienteServico {
	
	public void save(Paciente paciente);

	public List<Paciente> findAll();

	public List<Paciente> findAllativo();

}
