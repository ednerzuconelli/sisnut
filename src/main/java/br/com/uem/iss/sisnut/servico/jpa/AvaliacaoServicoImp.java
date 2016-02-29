package br.com.uem.iss.sisnut.servico.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.uem.iss.sisnut.modelo.Avaliacao;
import br.com.uem.iss.sisnut.modelo.Paciente;
import br.com.uem.iss.sisnut.repositorio.AvaliacaoRepositorio;
import br.com.uem.iss.sisnut.servico.AvaliacaoServico;

@Service("avaliacaoServico")
@Repository
@Transactional
public class AvaliacaoServicoImp implements AvaliacaoServico {

	@Autowired
	private AvaliacaoRepositorio avaliacaoRepositorio;
	
	@Override
	public void save(Avaliacao avaliacao) {
		avaliacaoRepositorio.save(avaliacao);
	}

	@Override
	public List<Avaliacao> findByPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		return (List<Avaliacao>) avaliacaoRepositorio.findByPaciente(paciente);
	}

}
