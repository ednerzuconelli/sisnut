package br.com.uem.iss.sisnut.servico.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.uem.iss.sisnut.modelo.Email;
import br.com.uem.iss.sisnut.repositorio.EmailRepositorio;
import br.com.uem.iss.sisnut.servico.EmailServico;


@Service("emailServico")
@Repository
@Transactional
public class EmailServicoImp implements EmailServico{

	@Autowired
	private EmailRepositorio emailRepositorio;
	
	@Override
	public void save(Email email) {
		
		
	}

}
