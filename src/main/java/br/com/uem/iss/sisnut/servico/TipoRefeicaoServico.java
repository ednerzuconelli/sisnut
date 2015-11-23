package br.com.uem.iss.sisnut.servico;

import java.util.List;

import br.com.uem.iss.sisnut.modelo.TipoRefeicao;

public interface TipoRefeicaoServico {

	public TipoRefeicao getById(Integer id);
	public void save(TipoRefeicao tipofeicao);
	public void delete(Integer id);
	public List<TipoRefeicao> findAll();
}
