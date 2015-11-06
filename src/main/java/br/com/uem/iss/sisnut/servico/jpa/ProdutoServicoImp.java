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
		// TODO Auto-generated method stub
		return produtorepositorio.findOne(id);
	}

	@Transactional
	@Override
	public void save(Produto produto) {
		// TODO Auto-generated method stub
		produtorepositorio.save(produto);
	}
	@Transactional
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		produtorepositorio.delete(id);
	}
	@Transactional(readOnly=true)
	@Override
	public List<Produto> findAll() {
		// TODO Auto-generated method stub
		return  produtorepositorio.findAll();
	}
	

}
