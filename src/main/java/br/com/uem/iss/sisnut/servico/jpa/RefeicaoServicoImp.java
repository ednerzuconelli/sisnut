package br.com.uem.iss.sisnut.servico.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.uem.iss.sisnut.modelo.Refeicao;
import br.com.uem.iss.sisnut.repositorio.RefeicaoRepositorio;
import br.com.uem.iss.sisnut.servico.RefeicaoServico;

@Service("refeicaoServico")
@Repository
@Transactional
public class RefeicaoServicoImp implements RefeicaoServico {

	@Autowired
	private RefeicaoRepositorio refeicaoRepositorio;
	
	@Transactional
	@Override
	public void save(Refeicao refeicao) {
		refeicaoRepositorio.save(refeicao);
		
	}

}
