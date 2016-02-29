package br.com.uem.iss.sisnut.repositorio;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import br.com.uem.iss.sisnut.modelo.Cardapio;

public interface CardapioRepositorio extends CrudRepository<Cardapio, Integer>, JpaSpecificationExecutor<Cardapio>{

}
