package br.com.uem.iss.sisnut.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.CrudMethods;
import org.springframework.data.repository.query.Param;

import br.com.uem.iss.sisnut.modelo.Avaliacao;

public interface AvaliacaoRepositorio extends CrudRepository<Avaliacao, Integer>, JpaSpecificationExecutor<Avaliacao>{

	@Query("select a from Avaliacao a where a.pessoa=:cod")
	List<Avaliacao> findByPaciente(@Param("cod") int cod);

}
