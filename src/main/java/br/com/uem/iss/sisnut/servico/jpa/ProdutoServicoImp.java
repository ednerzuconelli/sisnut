package br.com.uem.iss.sisnut.servico.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.uem.iss.sisnut.modelo.Produto;
import br.com.uem.iss.sisnut.repositorio.ProdutoRepositorio;
import br.com.uem.iss.sisnut.servico.ProdutoServico;

@Service("produtoServico")
@Repository
@Transactional
public class ProdutoServicoImp implements ProdutoServico {

	@Autowired
	private ProdutoRepositorio produtorepositorio;
	
	@Transactional(readOnly=true)
	@Override
	public Produto getById(Integer id) {
		
		return produtorepositorio.findOne(id);
	}

	@Transactional
	@Override
	public void save(Produto produto) {
		
		produtorepositorio.save(produto);
	}
	
	
	@Transactional(readOnly=true)
	@Override
	public List<Produto> findAll() {
		
		return  produtorepositorio.findAll();
	}
	

}
