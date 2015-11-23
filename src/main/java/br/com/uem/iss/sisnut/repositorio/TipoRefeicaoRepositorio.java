package br.com.uem.iss.sisnut.repositorio;


import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.uem.iss.sisnut.modelo.TipoRefeicao;

public interface TipoRefeicaoRepositorio extends CrudRepository<TipoRefeicao, Integer>, JpaSpecificationExecutor<TipoRefeicao> {

	@Query("select tp from TipoRefeicao tp where tp.ativo=1 and tp.id=:id")
	public TipoRefeicao getById(@Param("id") Integer id);
	
	@Query("update TipoRefeicao set ativo = 0 where (id>0 and id =:id)")
	public void delete(@Param("id") Integer id);
	
	@Query("select tp from TipoRefeicao tp where tp.ativo=1")
	public List<TipoRefeicao> findAll();
}
