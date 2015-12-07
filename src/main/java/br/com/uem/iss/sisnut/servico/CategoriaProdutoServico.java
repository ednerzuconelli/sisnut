package br.com.uem.iss.sisnut.servico;

import java.util.List;

import br.com.uem.iss.sisnut.modelo.CategoriaProduto;

public interface CategoriaProdutoServico {

	public CategoriaProduto getById(Integer id);
	public void save(CategoriaProduto categoriaprodutoservico);
	public void delete(Integer id);
	public List<CategoriaProduto> getAll();
}
