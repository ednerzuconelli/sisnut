package br.com.uem.iss.sisnut.repositorio;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import br.com.uem.iss.sisnut.modelo.Pessoa;

public interface PessoaRepositorio extends CrudRepository<Pessoa, Integer>, JpaSpecificationExecutor<Pessoa>{

}
