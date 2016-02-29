package br.com.uem.iss.sisnut.servico.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.uem.iss.sisnut.modelo.Cardapio;
import br.com.uem.iss.sisnut.repositorio.CardapioRepositorio;
import br.com.uem.iss.sisnut.servico.CardapioServico;

@Service("cardapioServico")
@Repository
@Transactional
public class CardapioServicoImp implements CardapioServico {
	@Autowired
	private CardapioRepositorio cardapioRepositorio;

	@Transactional
	@Override
	public void save(Cardapio cardapio) {
		cardapioRepositorio.save(cardapio);
		
	}

}
