package br.com.uem.iss.sisnut.servico.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.uem.iss.sisnut.modelo.CategoriaProduto;
import br.com.uem.iss.sisnut.repositorio.CategoriaProdutoRepositorio;
import br.com.uem.iss.sisnut.servico.CategoriaProdutoServico;

@Service("categoriaProdutoServico")
@Repository
@Transactional
public class CategoriaProdutoServicoImp implements CategoriaProdutoServico {

	@Autowired
	private CategoriaProdutoRepositorio categoriaprodutorespositorio;
	
	@Transactional(readOnly=true)
	@Override
	public CategoriaProduto getById(Integer id) {
		
		return  categoriaprodutorespositorio.getById(id);
	}

	@Transactional
	@Override
	public void save(CategoriaProduto categoriaproduto) {
		
		categoriaprodutorespositorio.save(categoriaproduto);
	}

	@Transactional
	@Override
	public void delete(Integer id) {
		
		categoriaprodutorespositorio.delete(id);
	}

	@Transactional(readOnly=true)
	@Override
	public List<CategoriaProduto> getAll() {
	
		return categoriaprodutorespositorio.findAll();
	}

}
