package br.com.uem.iss.sisnut.servico;

import java.util.List;

import br.com.uem.iss.sisnut.modelo.Produto;

public interface ProdutoServico {
	
	public Produto getById(Integer id);
	public void save(Produto produto);
	public List<Produto> findAll();
}
