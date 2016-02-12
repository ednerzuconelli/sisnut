package br.com.uem.iss.sisnut.repositorio;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.CrudMethods;

import br.com.uem.iss.sisnut.modelo.Avaliacao;

public interface AvaliacaoRepositorio extends CrudRepository<Avaliacao, Integer>, JpaSpecificationExecutor<Avaliacao>{

}
