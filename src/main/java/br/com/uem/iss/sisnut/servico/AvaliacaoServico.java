package br.com.uem.iss.sisnut.servico;

import java.util.List;

import br.com.uem.iss.sisnut.modelo.Avaliacao;

public interface AvaliacaoServico {
	public void save(Avaliacao avaliacao);

	public List<Avaliacao> findByPaciente(int cod);
}
