package br.com.uem.iss.sisnut.servico.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.uem.iss.sisnut.modelo.TipoRefeicao;
import br.com.uem.iss.sisnut.repositorio.TipoRefeicaoRepositorio;
import br.com.uem.iss.sisnut.servico.TipoRefeicaoServico;

@Service("tipoRefeicaoServico")
@Repository
@Transactional
public class TipoRefeicaoServicoImp implements TipoRefeicaoServico {

	@Autowired
	private TipoRefeicaoRepositorio tiporefeicaorepositorio;
	
	@Transactional(readOnly=true)
	@Override
	public TipoRefeicao getById(Integer id) {
		
		return tiporefeicaorepositorio.getById(id);
	}
    
	@Transactional
	@Override
	public void save(TipoRefeicao tiporefeicao) {
		
		tiporefeicaorepositorio.save(tiporefeicao);
	}

	@Transactional
	@Override
	public void delete(Integer id) {
		
		tiporefeicaorepositorio.delete(id);
	}

	@Transactional(readOnly=true)
	@Override
	public List<TipoRefeicao> findAll() {
		
		return tiporefeicaorepositorio.findAll();
	}

}
