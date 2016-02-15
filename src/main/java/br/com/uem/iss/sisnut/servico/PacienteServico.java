package br.com.uem.iss.sisnut.servico;

import java.util.List;

import br.com.uem.iss.sisnut.modelo.Paciente;


public interface PacienteServico {
	
	public void save(Paciente paciente);

	public List<Paciente> findAll();

	public List<Paciente> findAllativo();

	public Paciente findPacienteById(int pacienteCod);

}
