package br.com.uem.iss.sisnut.servico.jpa;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.uem.iss.sisnut.modelo.Pessoa;
import br.com.uem.iss.sisnut.repositorio.PessoaRepositorio;
import br.com.uem.iss.sisnut.servico.PessoaServico;


@Service("pessoaServico")
@Repository
@Transactional
public class PessoaServicoImp implements PessoaServico {

	@Autowired
	private PessoaRepositorio pessoarepositorio;
	
	@Transactional(readOnly=true)
	@Override
	public Pessoa getByCod(Integer cod) {
		
		return pessoarepositorio.findOne(cod);
	}
	
	@Transactional
	@Override
	public void save(Pessoa pessoa) {
		pessoarepositorio.save(pessoa);
		
	}

	
	@Transactional
	@Override
	public void delete(Integer id) {
		
		pessoarepositorio.delete(id);
	}

	@Transactional
	@Override
	public List<Pessoa> findAll() {
		
		return (List<Pessoa>) pessoarepositorio.findAll();
	}

}
