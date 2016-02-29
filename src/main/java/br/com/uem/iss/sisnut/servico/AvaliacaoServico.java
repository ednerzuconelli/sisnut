package br.com.uem.iss.sisnut.servico;

import java.util.List;

import br.com.uem.iss.sisnut.modelo.Avaliacao;
import br.com.uem.iss.sisnut.modelo.Paciente;

public interface AvaliacaoServico {
	public void save(Avaliacao avaliacao);

	public List<Avaliacao> findByPaciente(Paciente paciente);
}
