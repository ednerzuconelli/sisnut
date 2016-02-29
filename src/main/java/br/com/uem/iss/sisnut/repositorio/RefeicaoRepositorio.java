package br.com.uem.iss.sisnut.repositorio;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import br.com.uem.iss.sisnut.modelo.Refeicao;

public interface RefeicaoRepositorio extends CrudRepository<Refeicao, Integer>, JpaSpecificationExecutor<Refeicao>{

}
