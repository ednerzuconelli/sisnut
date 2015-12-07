package br.com.uem.iss.sisnut.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.uem.iss.sisnut.modelo.CategoriaProduto;


public interface CategoriaProdutoRepositorio extends CrudRepository<CategoriaProduto, Integer>, JpaSpecificationExecutor<CategoriaProduto> {

	@Query("select cp from CategoriaProduto cp where cp.ativo=1 and cp.id=:id")
	public CategoriaProduto getById(@Param("id") Integer id);
	
	@Query("update CategoriaProduto set ativo = 0 where (id>0 and id =:id)")
	public void delete(@Param("id") Integer id);
	
	@Query("select cp from CategoriaProduto cp where cp.ativo=1")
	public List<CategoriaProduto> findAll();
}
