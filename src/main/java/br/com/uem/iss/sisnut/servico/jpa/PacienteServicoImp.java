package br.com.uem.iss.sisnut.servico.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.uem.iss.sisnut.modelo.Paciente;
import br.com.uem.iss.sisnut.repositorio.PacienteRepositorio;
import br.com.uem.iss.sisnut.servico.PacienteServico;

@Service("pacienteServico")
@Repository
@Transactional
public class PacienteServicoImp implements PacienteServico {

	@Autowired
	private PacienteRepositorio pacienteRepositorio;
	
	@Override
	public void save(Paciente paciente) {
		// TODO Auto-generated method stub
		pacienteRepositorio.save(paciente);
		
	}

	@Override
	public List<Paciente> findAll() {
		// TODO Auto-generated method stub
		return (List<Paciente>)pacienteRepositorio.findAll();
	}

	@Override
	public List<Paciente> findAllativo() {
		// TODO Auto-generated method stub
		
		return (List<Paciente>)pacienteRepositorio.findAllativo();
	}

}
