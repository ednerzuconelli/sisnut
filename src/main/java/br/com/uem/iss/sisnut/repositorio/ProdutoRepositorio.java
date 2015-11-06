package br.com.uem.iss.sisnut.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



import org.springframework.data.repository.query.Param;

import br.com.uem.iss.sisnut.modelo.Produto;

public interface ProdutoRepositorio extends  CrudRepository<Produto,Integer>, JpaSpecificationExecutor<Produto> {

	@Query("select p from Produto p where p.ativo=1 and p.id=:id")
	public Produto getById(@Param("id") Integer id);
	
	@Query("update Produto set ativo = 0 where (id>0 and id =:id)")
	public void delete(@Param("id") Integer id);
	
	@Query("select p from Produto p where p.ativo=1")
	public List<Produto> findAll();
}
