package br.com.uem.iss.sisnut.servico;

import java.util.List;

import br.com.uem.iss.sisnut.modelo.Pessoa;



public interface PessoaServico {

	public Pessoa getByCod(Integer cod);
	public void save(Pessoa pessoa);
	public void delete(Integer id);
	public List<Pessoa> findAll();
}
