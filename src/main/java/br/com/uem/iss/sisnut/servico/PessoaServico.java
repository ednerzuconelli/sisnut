package br.com.uem.iss.sisnut.servico;

import br.com.uem.iss.sisnut.modelo.Pessoa;



public interface PessoaServico {

	public Pessoa getByCod(Integer cod);
	public void save(Pessoa pessoa);
}
